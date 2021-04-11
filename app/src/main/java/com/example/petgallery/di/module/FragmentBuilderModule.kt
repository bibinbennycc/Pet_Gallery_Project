package com.example.petgallery.di.module

import com.example.petgallery.feature.dogdetails.PetDetailsFragment
import com.example.petgallery.feature.gallery.view.PetGalleryFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {

    @ContributesAndroidInjector
    abstract fun bindPetGalleryFragment(): PetGalleryFragment

    @ContributesAndroidInjector
    abstract fun bindPetDetailsFragment(): PetDetailsFragment
}