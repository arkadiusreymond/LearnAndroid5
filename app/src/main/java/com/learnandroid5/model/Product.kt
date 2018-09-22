package com.learnandroid5.model

import com.google.gson.annotations.SerializedName

class Product {

    @SerializedName("name")
    val name : String? = null

    @SerializedName("price")
    val price : String? = null

    @SerializedName("images")
    val smallImages : ArrayList<String> = ArrayList()
}