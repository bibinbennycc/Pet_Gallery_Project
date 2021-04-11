package com.example.petgallery.feature.gallery.view


import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.petgallery.R
import com.example.petgallery.common.Status
import com.example.petgallery.feature.base.BaseFragment
import com.example.petgallery.feature.gallery.adapter.PetsListAdapter
import com.example.petgallery.feature.gallery.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_pet_gallery.*
import javax.inject.Inject

class PetGalleryFragment : BaseFragment(), PetsListAdapter.PetListListeners {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: PetsListAdapter

    override fun getLayoutId(): Int = R.layout.fragment_pet_gallery

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(requireActivity(), viewModelFactory)
            .get(MainViewModel::class.java)
        setupPetList()
        setupObservers()
    }

    private fun setupPetList() {
        pets_recyclerview.layoutManager = GridLayoutManager(context, 2)
        adapter = PetsListAdapter(arrayListOf(), this)
        pets_recyclerview.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.getDogsList().observe(viewLifecycleOwner, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        enableListView(true)
                        resource.data?.let { data -> retrieveList(data.imageUrlList) }
                    }
                    Status.ERROR -> {
                        enableListView(true)
                        Toast.makeText(context, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                        enableListView(false)
                    }
                }
            }
        })
    }

    private fun enableListView(enable: Boolean) {
        if (enable) {
            pets_recyclerview.visibility = View.VISIBLE
            progressBar.visibility = View.GONE
        } else {
            progressBar.visibility = View.VISIBLE
            pets_recyclerview.visibility = View.GONE
        }
    }

    private fun retrieveList(data: ArrayList<String>) {
        adapter.apply {
            addItems(data)
            notifyDataSetChanged()
        }
    }

    override fun onItemSelected(url: String) {
        viewModel.selectedPet.value = url
    }

}
