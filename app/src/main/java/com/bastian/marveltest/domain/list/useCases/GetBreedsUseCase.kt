package com.bastian.marveltest.domain.list.useCases

import com.bastian.marveltest.domain.list.DogRepository
import com.bastian.marveltest.domain.model.DogBreedModel

class GetBreedsUseCase(private val repository: DogRepository) {
    suspend operator fun invoke(): List<DogBreedModel> {
        return repository.getBreeds()
    }
}
