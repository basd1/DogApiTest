package com.bastian.marveltest.domain.model

import com.bastian.marveltest.data.model.DogBreedDto


fun DogBreedDto.toDomain(): DogBreedModel {
    return DogBreedModel(
        id = id,
        name = name,
        bredFor = bredFor,
        breedGroup = breedGroup,
        lifeSpan = lifeSpan,
        temperament = temperament,
        imageUrl = imageId?.let { "https://cdn2.thedogapi.com/images/$it.jpg" }
    )
}
