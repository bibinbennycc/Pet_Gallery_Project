package com.example.petgallery.feature.gallery.view

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.petgallery.R
import com.example.petgallery.feature.base.BaseActivity
import com.example.petgallery.feature.dogdetails.PetDetailsFragment
import com.example.petgallery.feature.gallery.viewmodel.MainViewModel
import javax.inject.Inject

class GalleryActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: MainViewModel

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
        addFragment(R.id.gallery_fragment_container, PetGalleryFragment())
        observePetSelection()
    }

    private fun observePetSelection() {
        viewModel.selectedPet.observe(this, Observer { petThumbnail ->
            showPetDetailsFragment(petThumbnail)
        })
    }

    private fun showPetDetailsFragment(thumbnailUrl: String) {
        val fragment = PetDetailsFragment.newInstance(thumbnailUrl)
        addFragment(R.id.gallery_fragment_container, fragment, true)
    }
}
