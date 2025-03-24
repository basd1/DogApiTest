package com.bastian.marveltest.domain.list.useCases

import com.bastian.marveltest.domain.list.DogRepository
import com.bastian.marveltest.domain.model.DogBreedModel

class GetBreedByIdUseCase(private val repository: DogRepository) {
    suspend operator fun invoke(breedId: String): DogBreedModel? {
        return repository.getBreedById(breedId)
    }
}
