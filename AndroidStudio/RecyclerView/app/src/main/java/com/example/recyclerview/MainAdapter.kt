package com.example.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ItemMainBinding

class MainAdapter : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    inner class MainViewHolder(itemView: ItemMainBinding) : RecyclerView.ViewHolder(itemView.root) {
        val txtTitle = itemView.mainTitle
        val txtContent = itemView.tvMainContent
    }

    var items: MutableList<MainData> = mutableListOf(
        MainData("Title1", "Content1"),
        MainData("Title2", "Content2"),
        MainData("Title3", "Content3")
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.MainViewHolder {
        val binding = ItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MainAdapter.MainViewHolder, position: Int) {
        items[position].let { item ->
            holder.apply {
                txtTitle.text = item.title
                txtContent.text = item.content
            }
        }
    }
}