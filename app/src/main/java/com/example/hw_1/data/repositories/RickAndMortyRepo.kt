package com.example.hw_1.data.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.hw_1.App
import com.example.hw_1.data.BaseResponse
import retrofit2.Call
import retrofit2.Response
import com.example.hw_1.data.Character

class RickAndMortyRepo {

    fun getCharacters(): LiveData<AppModel> {
        var result = MutableLiveData<AppModel>()

        App().apiService.getCharacters().enqueue(object :retrofit2.Callback<AppModel> {
            override fun onResponse(
                call: Call<AppModel>,
                response: Response<AppModel>
            ) {
              if (response.isSuccessful){
                  result.value = response.body()
              }
                Log.e("ololo", "onResponse: ${response.body()}", )
            }

            override fun onFailure(call: Call<AppModel>, t: Throwable) {
            }

        })

        return result
    }
}