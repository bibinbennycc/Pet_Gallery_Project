package com.example.petgallery.feature.gallery.model

import com.google.gson.annotations.SerializedName

data class DogsListResponse(
    @SerializedName("message")
    val imageUrlList: ArrayList<String>,
    val status: String
) {
}