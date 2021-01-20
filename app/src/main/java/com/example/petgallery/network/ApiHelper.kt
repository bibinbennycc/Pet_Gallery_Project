package com.example.petgallery.network

class ApiHelper(val apiService: ApiService) {
    suspend fun getDogsList() = apiService.getDogsList()
}