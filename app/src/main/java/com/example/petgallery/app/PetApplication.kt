package com.example.petgallery.app

import com.example.petgallery.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class PetApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out PetApplication> {
        return DaggerApplicationComponent.builder().create(this)
    }
}