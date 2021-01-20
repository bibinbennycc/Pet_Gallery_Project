package com.example.petgallery.feature.gallery.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.petgallery.R
import kotlinx.android.synthetic.main.item_dogs_list_layout.view.*


class DogsListAdapter(private var dogsList: ArrayList<String>,private val listener: DogListListeners): RecyclerView.Adapter<DogsListAdapter.DataViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_dogs_list_layout,parent,false)
        return DataViewHolder(view)
    }

    override fun getItemCount(): Int = dogsList.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(dogsList[position],position,listener)
    }

    fun addItems(list: List<String>) {
        dogsList.addAll(list)
    }

    interface DogListListeners{
        fun onItemSelected(url: String)
    }

    class DataViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(url: String, position: Int,listener: DogListListeners){
            itemView.apply {
                card_view.setOnClickListener {
                    listener.onItemSelected(url)
                }
                list_item_dog_breed_name.text = context.getString(R.string.list_item_title,position+1)
                Glide.with(list_item_dog_image_view.context)
                    .load(url)
                    .into(list_item_dog_image_view)
            }
        }
    }
}