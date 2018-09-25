package com.learnandroid5.service

import com.learnandroid5.model.BaseResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("products/populars_v2.json")
    fun getPopular() : Call<BaseResponse>

    @GET("products/promo_banners.json?")
    fun getPromoBanner() : Call<BaseResponse>

}