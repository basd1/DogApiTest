package com.bastian.marveltest.domain.model

data class DogBreedModel(
    val id: String,
    val name: String,
    val bredFor: String?,
    val breedGroup: String?,
    val lifeSpan: String,
    val temperament: String?,
    val imageUrl: String?
)
