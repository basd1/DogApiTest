package com.bastian.marveltest.domain.list

import com.bastian.marveltest.domain.model.DogBreedModel

interface DogRepository {
    suspend fun getBreeds(): List<DogBreedModel>
    suspend fun getBreedById(breedId: String): DogBreedModel?
}