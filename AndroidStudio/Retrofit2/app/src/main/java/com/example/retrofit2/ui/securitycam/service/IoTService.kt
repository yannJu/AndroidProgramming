package com.example.retrofit2.ui.securitycam.service

import com.example.retrofit2.ui.securitycam.data.SecFiles
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface IoTService {
    @GET("/api/sec_file/")
    fun requestSecFileList(@Query("page") page: Int): Call<SecFiles>
}

// singleton 객체
object IoT {
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://172.20.10.5:8000")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val service get() = retrofit.create(IoTService::class.java)
}