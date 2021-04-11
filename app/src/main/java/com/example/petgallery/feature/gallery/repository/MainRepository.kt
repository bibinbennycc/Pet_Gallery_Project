package com.example.petgallery.feature.gallery.repository

import com.example.petgallery.network.ApiService
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getDogsList() = apiService.getDogsList()
}