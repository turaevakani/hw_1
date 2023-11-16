package com.example.hw_1.data.remote.apiservice

import com.example.hw_1.data.repositories.AppModel
import retrofit2.Call
import retrofit2.http.GET

interface RickAndMortyApiService {

    @GET("character")
    fun getCharacters(): Call<AppModel>

    @GET("character/2")
    fun getCharacterById(): Call<Any>
}