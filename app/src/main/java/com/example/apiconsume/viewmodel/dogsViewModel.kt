package com.example.apiconsume.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.apiconsume.model.dogs
import com.example.apiconsume.model.DogsProvider

class dogsViewModel: ViewModel(){
    var modeldata = MutableLiveData<dogs>()

    fun getDogs() : LiveData<dogs>{
        modeldata = DogsProvider().getImage()
        return modeldata
    }
}