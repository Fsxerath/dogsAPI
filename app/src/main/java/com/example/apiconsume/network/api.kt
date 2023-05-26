package com.example.apiconsume.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class api {
    private var retrofit: Retrofit? = null
    private var baseURL = "https://dog.ceo/api/breed/"

    fun getClient(): Retrofit? {
        val client = OkHttpClient.Builder().build()
        retrofit = Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        return retrofit
    }
}