package com.example.apiconsume.network

import retrofit2.Call
import com.example.apiconsume.model.dogs
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiServices {
    @GET("husky/images")
    fun getImagesHusky(): Call<dogs>?
}
