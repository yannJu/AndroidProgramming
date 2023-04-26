package com.example.imagesearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import com.example.imagesearch.data.Document
import com.example.imagesearch.data.Images
import com.example.imagesearch.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import service.KakaoImageSearch

class MainActivity : AppCompatActivity() {
    val imageList = mutableListOf<Document>()
    val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.imageListView.apply {
            adapter = ImageListAdapter(imageList)
            layoutManager = GridLayoutManager(this@MainActivity, 3)
        }

        binding.btnSearch.setOnClickListener {
            val keyword = binding.editKeyword.text.toString()

            searchImage(keyword)
            binding.editKeyword.setText("")
        }
    }

    private fun searchImage(keyword: String) {
        KakaoImageSearch.service
            .requestSearchImage(keyword = keyword, page = 1)
            .enqueue(object : Callback<Images> {
                override fun onFailure(call: Call<Images>, t: Throwable) {
                    Log.e("------", t.toString())
                }

                override fun onResponse(call: Call<Images>, response: Response<Images>) {
                    if (response.isSuccessful) {
                        val image = response.body()

                        imageList.addAll(image!!.documents)
                        binding.imageListView.adapter?.notifyDataSetChanged()
                    }
                }
            })
    }
}