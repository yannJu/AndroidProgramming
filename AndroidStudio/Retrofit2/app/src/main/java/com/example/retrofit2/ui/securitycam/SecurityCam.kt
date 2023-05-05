package com.example.retrofit2.ui.securitycam

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit2.R
import com.example.retrofit2.databinding.FragmentSecurityCamBinding
import com.example.retrofit2.databinding.FragmentSlideshowBinding
import com.example.retrofit2.databinding.ItemSecFileBinding
import com.example.retrofit2.ui.securitycam.data.SecFile
import com.example.retrofit2.ui.securitycam.data.SecFiles
import com.example.retrofit2.ui.securitycam.service.IoT
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SecurityCam : Fragment() {
    val secFileList = mutableListOf<SecFile>()//

    private var _binding: FragmentSecurityCamBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecurityCamBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Recycler View 초기화
        // Adapter 연결
        binding.listView.apply {
            adapter = MyAdapter()
            layoutManager = LinearLayoutManager(requireContext())
        }

        // api 호출
        IoT.service.requestSecFileList(page = 1)
            .enqueue(object: Callback<SecFiles> {
                override fun onResponse(call: Call<SecFiles>, response: Response<SecFiles>) {
                    if (response.isSuccessful) {
                        val secFiles = response.body()

                        //둘다 동일
                        //secFileList.addAll(secFiles!!.results)
                        secFileList += secFiles!!.results

                        //목록이 변경됨을 adapter 에게 알리기
                        binding.listView.adapter?.notifyDataSetChanged()
                    }
                }

                override fun onFailure(call: Call<SecFiles>, t: Throwable) {
                    Log.e("요청 실패", t.toString())
                }

            })
    }

    fun onItemClick(secFile: SecFile, position: Int) {
        val url = secFile.secFile
//        Toast.makeText(requireContext(), url, Toast.LENGTH_SHORT).show()

        //프래그먼트 이동
        val bundle = Bundle()

        bundle.putString(ARG_URL, url)
        findNavController().navigate(R.id.action_security_cam_to_nav_video, bundle)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    // 내부 클래스 Adapter 정의
    inner class MyAdapter : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
        inner class ViewHolder(val binding: ItemSecFileBinding) :
            RecyclerView.ViewHolder(binding.root) {
                val txtFileName = binding.txtFileName
                val txtSecFile = binding.txtSecFile
            }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val binding = ItemSecFileBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )

            return ViewHolder(binding)
        }

        override fun getItemCount() = secFileList.size

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            secFileList[position].let {item ->
                holder.txtFileName.text = item.fileName
                holder.txtSecFile.text = item.secFile
                holder.itemView.setOnClickListener {
                    onItemClick(item, position)
                }
            }
        }
    }
}