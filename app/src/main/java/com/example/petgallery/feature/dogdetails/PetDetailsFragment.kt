package com.example.petgallery.feature.dogdetails


import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.example.petgallery.R
import com.example.petgallery.feature.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_pet_details.*

private const val BUNDLE_ARGUMENT_DOG_IMAGE_URL = "bundle_argument_dog_image_url"

class PetDetailsFragment : BaseFragment() {

    companion object {
        fun newInstance(thumbnailUrl: String): PetDetailsFragment {
            return PetDetailsFragment().apply {
                val bundle = Bundle()
                bundle.putString(BUNDLE_ARGUMENT_DOG_IMAGE_URL, thumbnailUrl)
                arguments = bundle
            }
        }
    }

    override fun getLayoutId(): Int = R.layout.fragment_pet_details

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolbarBackButton(pet_details_toolbar)
        arguments?.let {
            val thumbnailUrl = it.getString(BUNDLE_ARGUMENT_DOG_IMAGE_URL, "")
            loadPreview(thumbnailUrl)
        }
    }

    private fun loadPreview(url: String) {
        if (url.isNotEmpty()) {
            Glide.with(pet_details_preview.context)
                .load(url)
                .into(pet_details_preview)
        }
    }

}
