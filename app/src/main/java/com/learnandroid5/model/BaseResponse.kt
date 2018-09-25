package com.learnandroid5.model

import com.google.gson.annotations.SerializedName

class BaseResponse {
    @SerializedName("status")
    val status: String = ""

    @SerializedName("populars")
    val populars : ArrayList<Popular> = ArrayList<Popular>()

    @SerializedName("promo_banners")
    val promoBanners : ArrayList<PromoBanner> = ArrayList<PromoBanner>()
}