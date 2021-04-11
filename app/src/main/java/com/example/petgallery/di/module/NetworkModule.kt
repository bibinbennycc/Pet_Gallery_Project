package com.example.petgallery.di.module

import com.example.petgallery.network.ApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    private val baseURL = "https://dog.ceo/api/"

    @Provides
    fun providesApiService(): ApiService {
        return Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}