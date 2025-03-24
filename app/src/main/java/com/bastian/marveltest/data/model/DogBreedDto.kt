package com.bastian.marveltest.data.model

import com.google.gson.annotations.SerializedName

data class DogBreedDto(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("bred_for") val bredFor: String?,
    @SerializedName("breed_group") val breedGroup: String?,
    @SerializedName("life_span") val lifeSpan: String,
    @SerializedName("temperament") val temperament: String?,
    @SerializedName("reference_image_id") val imageId: String?
)

