package com.example.detectperson.data


import com.google.gson.annotations.SerializedName

data class SecFiles(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("previous")
    val previous: String,
    @SerializedName("results")
    val results: List<SecFile>
)