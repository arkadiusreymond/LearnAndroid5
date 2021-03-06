package com.learnandroid5.model

import com.google.gson.annotations.SerializedName

class Product {

    @SerializedName("name")
    val name : String? = null

    @SerializedName("price")
    val price : Double? = null

    @SerializedName("images")
    val smallImages : ArrayList<String> = ArrayList()

    @SerializedName("deal_info")
    val dealInfo : DealInfo? = null

    @SerializedName("rating")
    val rating : Rating? = null
}