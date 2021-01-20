package com.example.petgallery.feature.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.petgallery.R

abstract class BaseDialogFragment: DialogFragment() {

    abstract fun getLayoutId():Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutId(), container, false)
    }

    override fun getTheme(): Int {
        return R.style.FullScreenDialogTheme
    }

}