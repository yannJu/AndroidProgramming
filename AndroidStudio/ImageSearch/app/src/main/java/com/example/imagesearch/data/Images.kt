package com.example.imagesearch.data


import com.google.gson.annotations.SerializedName

data class Images(
    @SerializedName("documents")
    val documents: List<Document>,
    @SerializedName("meta")
    val meta: Meta
)