package com.example.wsrfood.server

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface RetApi {
    @POST("auth/login")
    fun login(@Body hashMap: HashMap<String, String>): Call<HashMap<String, Int>>

    @GET("dishes?version=1.01")
    fun getDishes(): Call<ArrayList<Food>>
}