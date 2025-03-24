package com.bastian.marveltest.data.list

import com.bastian.marveltest.data.ApiService
import com.bastian.marveltest.domain.list.DogRepository
import com.bastian.marveltest.domain.model.DogBreedModel
import com.bastian.marveltest.domain.model.toDomain

class DogRepositoryImpl(private val apiService: ApiService) : DogRepository {
    override suspend fun getBreeds(): List<DogBreedModel> {
        return apiService.getBreeds().map { it.toDomain() }
    }

    override suspend fun getBreedById(breedId: String): DogBreedModel? {
        return apiService.getBreedById(breedId).toDomain()
    }
}