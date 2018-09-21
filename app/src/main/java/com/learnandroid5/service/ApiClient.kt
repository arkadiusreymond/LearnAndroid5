package com.learnandroid5.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    companion object {
        fun getClient() : Retrofit {
            val BASE_URL = "https://api.bukalapak.com/v2/"
            val retrofit: Retrofit = Retrofit.Builder().
                    baseUrl(BASE_URL).
                    addConverterFactory(GsonConverterFactory.create())
                    .build()

            return retrofit
        }
    }
}