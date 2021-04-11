package com.example.petgallery.feature.gallery.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.petgallery.R
import kotlinx.android.synthetic.main.item_pets_list_layout.view.*

class PetsListAdapter(
    private var dogsList: ArrayList<String>,
    private val listener: PetListListeners
) : RecyclerView.Adapter<PetsListAdapter.DataViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pets_list_layout, parent, false)
        return DataViewHolder(view)
    }

    override fun getItemCount(): Int = dogsList.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(dogsList[position], position, listener)
    }

    fun addItems(list: List<String>) {
        dogsList.addAll(list)
    }

    interface PetListListeners {
        fun onItemSelected(url: String)
    }

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(url: String, position: Int, listener: PetListListeners) {
            itemView.apply {
                card_view.setOnClickListener {
                    listener.onItemSelected(url)
                }
                list_item_pet_breed_name.text =
                    context.getString(R.string.list_item_title, position + 1)
                Glide.with(list_item_pet_image_view.context)
                    .load(url)
                    .into(list_item_pet_image_view)
            }
        }
    }
}