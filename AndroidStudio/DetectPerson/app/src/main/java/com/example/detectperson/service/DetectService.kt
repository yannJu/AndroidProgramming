package com.example.detectperson.service

import com.example.detectperson.data.SecFiles
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface DetectService {
    @GET("/api/detect/")
    fun requestSecFileList(
        @Query("page") page: Int
    ): Call<SecFiles>
}


object Detect {
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://172.20.10.5:8000")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service get() = retrofit.create(DetectService::class.java)
}