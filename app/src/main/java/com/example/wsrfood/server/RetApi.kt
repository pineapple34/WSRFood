package com.example.wsrfood.server

import retrofit2.Call
import retrofit2.http.GET

interface RetApi {
    @GET("dishes?version=1.0")
    fun getDishes(): Call<ArrayList<Food>>
}