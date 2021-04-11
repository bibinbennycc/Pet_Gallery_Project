package com.example.petgallery.di.module

import com.example.petgallery.feature.gallery.view.GalleryActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
    abstract fun bindGalleryActivity(): GalleryActivity
}