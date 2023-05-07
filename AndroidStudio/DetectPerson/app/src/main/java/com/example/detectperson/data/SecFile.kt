package com.example.detectperson.data


import com.google.gson.annotations.SerializedName

data class SecFile(
    @SerializedName("file_name")
    val fileName: String,
    @SerializedName("sec_file")
    val secFile: String
)