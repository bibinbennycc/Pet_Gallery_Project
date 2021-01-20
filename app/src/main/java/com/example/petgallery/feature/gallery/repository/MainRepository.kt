package com.example.petgallery.feature.gallery.repository

import com.example.petgallery.network.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {
    suspend fun getDogsList() = apiHelper.getDogsList()
}