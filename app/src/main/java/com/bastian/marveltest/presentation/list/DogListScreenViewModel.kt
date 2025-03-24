package com.bastian.marveltest.presentation.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bastian.marveltest.domain.list.useCases.GetBreedsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DogListScreenViewModel(private val getDogBreedsUseCase: GetBreedsUseCase) : ViewModel() {

    private val _uiState = MutableStateFlow<DogListUiState>(DogListUiState.Loading)
    val uiState: StateFlow<DogListUiState> = _uiState.asStateFlow()

    fun fetchDogBreeds() {
        viewModelScope.launch {
            try {
                val dogs = getDogBreedsUseCase()
                _uiState.value = DogListUiState.Success(dogs)
            } catch (e: Exception) {
                _uiState.value = DogListUiState.Error(e.message ?: "Error")
            }
        }
    }
}