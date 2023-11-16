package com.example.hw_1.data

import java.io.Serializable

data class BaseResponse<T>(
    val results: List<T>
) : Serializable

data class Character(
    val id: Int,
    val name: String,
    val image: String
)