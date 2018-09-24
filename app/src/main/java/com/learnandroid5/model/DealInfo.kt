package com.learnandroid5.model

import com.google.gson.annotations.SerializedName

class DealInfo {
    @SerializedName("original_price")
    val originalPrice : Double? = null

    @SerializedName("discount_price")
    val discountPrice : Double? = null

    @SerializedName("discount_percentage")
    val percentageDiscount : Int? = null
}