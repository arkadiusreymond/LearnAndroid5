package com.learnandroid5.model

import com.google.gson.annotations.SerializedName

class Popular{

    @SerializedName("title")
    val title : String? = null

    @SerializedName("campaign_id")
    val campign_id : Int? = null

    @SerializedName("products")
    val products : ArrayList<Product> = ArrayList()
}