package com.example.gallery

import android.net.Uri
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class PageAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager, lifecycle) {
    var uris = mutableListOf<Uri>() // 보여줄 프래그먼트 소스를 담은 List

    override fun getItemCount(): Int = uris.size
    override fun createFragment(position: Int): Fragment = PhotoFragment.newInstance(uris[position])
}