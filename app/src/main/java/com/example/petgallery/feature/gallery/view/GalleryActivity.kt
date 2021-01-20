package com.example.petgallery.feature.gallery.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.petgallery.R
import com.example.petgallery.common.Status
import com.example.petgallery.common.viewmodel.ViewModelFactory
import com.example.petgallery.feature.base.BaseActivity
import com.example.petgallery.feature.dogdetails.DogDetailsDialogFragment
import com.example.petgallery.feature.gallery.adapter.DogsListAdapter
import com.example.petgallery.feature.gallery.viewmodel.MainViewModel
import com.example.petgallery.network.ApiHelper
import com.example.petgallery.network.RetrofitBuilder
import kotlinx.android.synthetic.main.activity_main.*

class GalleryActivity : BaseActivity(),
    DogsListAdapter.DogListListeners {

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: DogsListAdapter
    private val DETAILS_FRAGMENT_TAG = "dogDetailsFragmentTag"

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupViewModel()
        setupUI()
        setupObservers()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelper(RetrofitBuilder.apiService))
        ).get(MainViewModel::class.java)
    }

    private fun setupUI() {
        recyclerView.layoutManager = GridLayoutManager(this,2)
        adapter =
            DogsListAdapter(arrayListOf(), this)
        recyclerView.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.getDogsList().observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        enableListView(true)
                        resource.data?.let { data -> retrieveList(data.imageUrlList) }
                    }
                    Status.ERROR -> {
                        enableListView(true)
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                        enableListView(false)
                    }
                }
            }
        })
    }

    private fun enableListView(enable: Boolean){
        if(enable){
            recyclerView.visibility = View.VISIBLE
            progressBar.visibility = View.GONE
        }else{
            progressBar.visibility = View.VISIBLE
            recyclerView.visibility = View.GONE
        }
    }

    private fun retrieveList(data: List<String>) {
        adapter.apply {
            addItems(data)
            notifyDataSetChanged()
        }
    }

    override fun onItemSelected(url: String) {
        val fragment = DogDetailsDialogFragment.newInstance(url)
        fragment.show(supportFragmentManager,DETAILS_FRAGMENT_TAG)
    }
}
