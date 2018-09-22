package com.learnandroid5.service

import com.learnandroid5.model.PopularResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("products/populars_v2.json")
    fun getPopular() : Call<PopularResponse>
}