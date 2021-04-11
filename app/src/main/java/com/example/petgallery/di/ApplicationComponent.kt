package com.example.petgallery.di

import com.example.petgallery.app.PetApplication
import com.example.petgallery.di.module.ActivityBuilderModule
import com.example.petgallery.di.module.FragmentBuilderModule
import com.example.petgallery.di.module.NetworkModule
import com.example.petgallery.di.module.ViewModelModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, ActivityBuilderModule::class, FragmentBuilderModule::class, NetworkModule::class, ViewModelModule::class])
interface ApplicationComponent : AndroidInjector<PetApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<PetApplication>()
}