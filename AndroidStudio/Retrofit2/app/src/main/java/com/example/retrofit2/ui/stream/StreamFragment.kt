package com.example.retrofit2.ui.stream

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.retrofit2.R
import com.example.retrofit2.databinding.FragmentSecurityCamBinding
import com.example.retrofit2.databinding.FragmentStreamBinding
import com.github.niqdev.mjpeg.DisplayMode
import com.github.niqdev.mjpeg.Mjpeg
import com.github.niqdev.mjpeg.MjpegInputStream

class StreamFragment : Fragment() {

    private var _binding: FragmentStreamBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStreamBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Mjpeg.newInstance()
            .open("http://172.20.10.11:8000/mjpeg/stream/", 5)
            .subscribe { inputStream: MjpegInputStream? ->
                binding.mjpeg.setSource(inputStream!!)
                binding.mjpeg.setDisplayMode(DisplayMode.BEST_FIT)
            }
    }

    override fun onPause() {
        super.onPause()

        if (binding.mjpeg.isStreaming)
            binding.mjpeg.stopPlayback()
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}