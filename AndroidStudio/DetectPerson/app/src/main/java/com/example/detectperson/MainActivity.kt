package com.example.detectperson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.detectperson.data.SecFiles
import com.example.detectperson.data.SecFile
import com.example.detectperson.databinding.ActivityMainBinding
import com.example.detectperson.databinding.ItemMainBinding
import com.example.detectperson.service.Detect
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val secFileList = mutableListOf<SecFile>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.listView.apply {
            adapter = MyAdapter()
            layoutManager = GridLayoutManager(this@MainActivity, 3)
//            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        Detect.service.requestSecFileList(page=1)
            .enqueue(object: Callback<SecFiles> {
                override fun onResponse(call: Call<SecFiles>, response: Response<SecFiles>) {
                    if (response.isSuccessful) {
                        val secFiles = response.body()

                        secFileList += secFiles!!.results
                        binding.listView.adapter?.notifyDataSetChanged()
                    }
                }

                override fun onFailure(call: Call<SecFiles>, t: Throwable) {
                    Log.e("요청 실패", t.toString())
                    Log.e("요청 실패2", call.toString())
                }
            })
    }

    inner class MyAdapter : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
        inner class ViewHolder(val binding: ItemMainBinding) :
            RecyclerView.ViewHolder(binding.root) {
//                val txtTitle = binding.txtItemTitle
//                val txtItem = binding.txtItemPath
                val img = binding.image
            }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val binding = ItemMainBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )

            return ViewHolder(binding)
        }

        override fun getItemCount() = secFileList.size

        override fun onBindViewHolder(holder: MyAdapter.ViewHolder, position: Int) {
            secFileList[position].let {doc ->
                Glide.with(holder.img).load(doc.secFile).into(holder.img)
//                holder.txtTitle.text = doc.fileName
//                holder.txtItem.text = doc.secFile
            }
        }
    }

    fun onItemClick(item: SecFile, position: Int) {
        Toast.makeText(application, item.fileName, Toast.LENGTH_SHORT).show()
    }
}