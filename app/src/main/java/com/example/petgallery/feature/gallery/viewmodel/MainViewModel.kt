package com.example.petgallery.feature.gallery.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.petgallery.common.model.Resource
import com.example.petgallery.feature.gallery.repository.MainRepository
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class MainViewModel(private val mainRepository: MainRepository): ViewModel() {

    fun getDogsList() = liveData (Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try{
            emit(Resource.success(mainRepository.getDogsList()))
        }catch (exception: Exception){
            emit(Resource.error(data=null,message= exception.message ?: "Something went wrong"))
        }
    }
}