package com.bastian.marveltest.di

import com.bastian.marveltest.data.ApiService
import com.bastian.marveltest.data.list.DogRepositoryImpl
import com.bastian.marveltest.domain.list.DogRepository
import com.bastian.marveltest.domain.list.useCases.GetBreedByIdUseCase
import com.bastian.marveltest.domain.list.useCases.GetBreedsUseCase
import com.bastian.marveltest.presentation.list.DogListScreenViewModel
import okhttp3.OkHttpClient
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single { OkHttpClient.Builder().build() }

    single {
        Retrofit.Builder()
            .baseUrl("https://api.thedogapi.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
    }

    single { get<Retrofit>().create(ApiService::class.java) }

    single<DogRepository> { DogRepositoryImpl(get()) }

    factory { GetBreedsUseCase(get()) }
    factory { GetBreedByIdUseCase(get()) }

    viewModelOf(::DogListScreenViewModel)

}
