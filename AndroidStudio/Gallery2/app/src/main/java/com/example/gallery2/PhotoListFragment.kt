package com.example.gallery2

import android.Manifest
import android.content.ContentUris
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.gallery2.databinding.FragmentPhotoListBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class PhotoListFragment : Fragment() {

    private var _binding: FragmentPhotoListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val requestPermissionsLauncher = registerForActivityResult (
        ActivityResultContracts.RequestPermission()) { isGranted ->
        if (isGranted) {
            getAllPhotos()
        }
        else {
            Toast.makeText(requireContext(), "접근 권한 없음", Toast.LENGTH_SHORT).show()
            requireActivity().finish()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentPhotoListBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // ========= Adapter 연결
        binding.listView.apply {
            adapter = PhotoAdapter() {uri, position ->
                // navigate 통해 이동할 때 전달 데이터는 bundle 에 담는다.
                val bundle = Bundle()

                bundle.putParcelable("URI", uri) // 기본 객체가 아니므로 parcelable 로 보내야된다...
                findNavController().navigate(R.id.action_ListFragment_to_DetailFragment, bundle)
            }
            layoutManager = GridLayoutManager(requireContext(), 3)
        }
        // =====================

        // 권한 검사 ===================
        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            requestPermissionsLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
            return
        }
        // =============================
        getAllPhotos()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    fun getAllPhotos() {
        val uris = mutableListOf<Uri>()

        requireActivity().contentResolver.query(
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
            null,
            null,
            null,
            "${MediaStore.Images.ImageColumns.DATE_TAKEN} DESC"
        )?.use { cursor ->
            while(cursor.moveToNext()) {
                val id = cursor.getLong(cursor.getColumnIndexOrThrow(
                    MediaStore.Images.Media._ID
                ))
                val contentUri = ContentUris.withAppendedId(
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                    id
                )
                uris.add(contentUri)
            }
        }
        Log.d("PhotoListFragment", "getAllPhotos : $uris")

        val adapter = binding.listView.adapter as PhotoAdapter
        adapter.uris = uris
        adapter.notifyDataSetChanged()
    }
}