package com.learnandroid5.model

import com.google.gson.annotations.SerializedName

class Rating {
    @SerializedName("average_rate")
    val averageRate : Float? = null

    @SerializedName("user_count")
    val userCount : Int? = null

}