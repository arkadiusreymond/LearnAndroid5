package com.learnandroid5.utils

class Utils {
    companion object {
        fun formatShortPrice(price : Double?) : String{
            var shortPrice = price!! /1000
            var textPrice = shortPrice.toString()
            textPrice = textPrice.replace(".", ",")
            textPrice = "Rp." + textPrice + "rb"
            if (textPrice.contains(",0")){
                textPrice = textPrice.replace(",0","")
            }
            return textPrice
        }
    }
}