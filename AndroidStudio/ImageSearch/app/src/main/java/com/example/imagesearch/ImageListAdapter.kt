package com.example.imagesearch

import android.content.ClipData
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.imagesearch.data.Document
import com.example.imagesearch.databinding.ItemImageBinding

class ImageListAdapter(val imageList: List<Document>) : RecyclerView.Adapter<ImageListAdapter.ViewHolder>() {
    inner class ViewHolder(val imageView: ImageView) :
        RecyclerView.ViewHolder(imageView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemImageBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding.root)
    }

    override fun getItemCount() = imageList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        imageList[position].let {doc ->
            Glide.with(holder.imageView).load(doc.thumbnailUrl).into(holder.imageView)
        }
    }
}