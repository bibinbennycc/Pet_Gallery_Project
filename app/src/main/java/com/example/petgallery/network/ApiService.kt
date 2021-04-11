package com.example.petgallery.network

import com.example.petgallery.feature.gallery.model.PetsListResponse
import retrofit2.http.GET

interface ApiService {

    @GET("breeds/image/random/50")
    suspend fun getDogsList(): PetsListResponse
}