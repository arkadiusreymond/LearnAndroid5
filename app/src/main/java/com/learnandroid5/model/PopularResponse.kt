package com.learnandroid5.model

import com.google.gson.annotations.SerializedName

class PopularResponse {
    @SerializedName("status")
    val status: String = ""

    @SerializedName("populars")
    val populars : ArrayList<Popular> = ArrayList<Popular>()
}