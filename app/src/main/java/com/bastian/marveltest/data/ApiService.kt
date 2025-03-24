package com.bastian.marveltest.data

import com.bastian.marveltest.data.model.DogBreedDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("breeds")
    suspend fun getBreeds(): List<DogBreedDto>

    @GET("breeds/{id}")
    suspend fun getBreedById(@Path("id") breedId: String): DogBreedDto
}

