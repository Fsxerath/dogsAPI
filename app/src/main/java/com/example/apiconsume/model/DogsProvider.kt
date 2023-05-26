package com.example.apiconsume.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.apiconsume.network.ApiServices
import com.example.apiconsume.network.api
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DogsProvider {
    var apInterface: ApiServices? = null
    val model = MutableLiveData<dogs>()

    fun getImage() : MutableLiveData<dogs> {
        apInterface = api().getClient()?.create(ApiServices :: class.java)

        apInterface?.getImagesHusky()?.enqueue(object : Callback<dogs> {
            override fun onResponse(call: Call<dogs>, response: Response<dogs>) {
                Log.d("CODEHTTP", response.code().toString())
                val resource: dogs? = response.body()

                Log.d("TAG", response.body().toString())
                model.value = resource as dogs
            }

            override fun onFailure(call: Call<dogs>, t: Throwable) {
                Log.d("HTTPERROR", t?.message.toString())
                call.cancel()
            }

        })

        return model
    }
}