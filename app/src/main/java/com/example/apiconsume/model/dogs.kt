package com.example.apiconsume.model
import com.google.gson.annotations.SerializedName

data class dogs(
    @SerializedName("status")
    var status: String,
    @SerializedName("message")
    var images: List<String>
)