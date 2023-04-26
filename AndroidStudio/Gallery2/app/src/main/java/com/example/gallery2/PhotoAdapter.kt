package com.example.gallery2

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.gallery2.databinding.ItemImgBinding
import java.text.FieldPosition

class PhotoAdapter(val onItemClick: (uri: Uri, position: Int) -> Unit): RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {
    var uris = mutableListOf<Uri>()

    inner class PhotoViewHolder(itemView: ItemImgBinding):
            RecyclerView.ViewHolder(itemView.root) {
                val imgView = itemView.root as ImageView
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val binding = ItemImgBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhotoViewHolder(binding)
    }

    override fun getItemCount() = uris.size

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        uris[position].let {uri ->
            holder.imgView.load(uri)
            holder.imgView.setOnClickListener {
                onItemClick(uri, position)
            }
        }
    }
}