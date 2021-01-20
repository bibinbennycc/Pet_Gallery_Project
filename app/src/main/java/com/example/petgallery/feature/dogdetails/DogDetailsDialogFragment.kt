package com.example.petgallery.feature.dogdetails


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide

import com.example.petgallery.R
import com.example.petgallery.common.Constants
import com.example.petgallery.feature.base.BaseDialogFragment
import kotlinx.android.synthetic.main.fragment_dog_details_dialog.*

class DogDetailsDialogFragment : BaseDialogFragment() {

    companion object {
        fun newInstance(thumbnailUrl: String): DogDetailsDialogFragment {
            return DogDetailsDialogFragment().apply {
                val bundle = Bundle()
                bundle.putString(Constants.BUNDLE_ARGUMENT_DOG_IMAGE_URL, thumbnailUrl)
                arguments = bundle
            }
        }
    }

    override fun getLayoutId(): Int = R.layout.fragment_dog_details_dialog

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            val thumbnailUrl = it.getString(Constants.BUNDLE_ARGUMENT_DOG_IMAGE_URL,"")
            loadPreview(thumbnailUrl)
        }
        setBackButton()
    }

    private fun setBackButton(){
        dog_details_back_button.setOnClickListener {
            dismiss()
        }
    }

    private fun loadPreview(url: String){
        if(url.isNotEmpty()){
            Glide.with(dog_details_preview.context)
                .load(url)
                .into(dog_details_preview)
        }
    }

}
