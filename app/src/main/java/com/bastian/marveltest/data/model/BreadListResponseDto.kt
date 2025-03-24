package com.bastian.marveltest.data.model

import com.google.gson.annotations.SerializedName

data class BreedListResponseDto(
    @SerializedName("message") val breeds: Map<String, List<String>>,
    @SerializedName("status") val status: String
)
