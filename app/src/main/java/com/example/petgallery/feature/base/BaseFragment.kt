package com.example.petgallery.feature.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import dagger.android.support.DaggerFragment

abstract class BaseFragment : DaggerFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayoutId(), container, false)
    }

    fun setupToolbarBackButton(toolbar: Toolbar) {
        toolbar.setNavigationOnClickListener { requireActivity().onBackPressed() }
    }

    abstract fun getLayoutId(): Int
}