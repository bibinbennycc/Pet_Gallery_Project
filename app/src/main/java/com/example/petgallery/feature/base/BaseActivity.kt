package com.example.petgallery.feature.base

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
    }

    fun addFragment(containerId: Int, fragment: BaseFragment, isAddToBackStack: Boolean = false) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.apply {
            add(containerId, fragment)
            if (isAddToBackStack) {
                addToBackStack(null)
            }
            commit()
        }
    }

    abstract fun getLayoutId(): Int
}