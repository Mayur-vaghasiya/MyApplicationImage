package com.example.myapplication.network

import com.example.myapplication.model.ItemImageResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("user")
    fun getItemImage(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int,
    ): Call<ItemImageResponse.Data>

}