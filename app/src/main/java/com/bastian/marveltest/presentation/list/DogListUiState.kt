package com.bastian.marveltest.presentation.list

import com.bastian.marveltest.domain.model.DogBreedModel

sealed class DogListUiState {
    data object Loading : DogListUiState()
    data class Success(val dogs: List<DogBreedModel>) : DogListUiState()
    data class Error(val message: String) : DogListUiState()
}