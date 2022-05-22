package com.example.wsrfood.server

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MyRetrofit {
    fun getRetrofit(): RetApi = Retrofit.Builder()
        .baseUrl("https://food.madskill.ru/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(RetApi::class.java)

    val imgUrl = "http://food.madskill.ru/up/images/"
}