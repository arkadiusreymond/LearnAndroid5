package com.learnandroid5.adapter

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.support.v7.widget.RecyclerView
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.learnandroid5.R
import com.learnandroid5.model.Product
import com.learnandroid5.utils.Utils

class PopularProductAdapter(val products : ArrayList<Product>) : RecyclerView.Adapter<PopularProductAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(products.get(position))
    }

    override fun getItemCount() = products.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.popular_product_item, parent, false)
        return ViewHolder(view)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private var view : View = itemView
        private var product : Product? = null
        var productName = view.findViewById(R.id.product_name) as TextView
        var productOriginalPrice = view.findViewById<TextView>(R.id.original_price)
        var productDiscountPrice = view.findViewById<TextView>(R.id.discount_price)
        var imageProduct = view.findViewById<ImageView>(R.id.image_promo_banner)
        var persentageDiscount = view.findViewById<TextView>(R.id.percantage_discount)
        var productRatingBar = view.findViewById<RatingBar>(R.id.rating)
        var productUserCount = view.findViewById<TextView>(R.id.user_count)


        override fun onClick(p0: View?) {
            Toast.makeText(view.context, "Item diklik", Toast.LENGTH_LONG).show()
        }

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(product: Product) {
            this.product = product
            productName.text = product.name
            persentageDiscount.bringToFront()
            productRatingBar.rating = product.rating?.averageRate!!
            productUserCount.text = "(" + product.rating.userCount.toString()+")"

            if(product.dealInfo!!.originalPrice==null){
                productOriginalPrice.text = Utils.formatShortPrice(product.price)
                productOriginalPrice.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16.0F)
                productOriginalPrice.paintFlags = Paint.ANTI_ALIAS_FLAG
                productOriginalPrice.typeface = Typeface.DEFAULT_BOLD
                productOriginalPrice.setTextColor(Color.parseColor("#333333"))
                productDiscountPrice.visibility = View.INVISIBLE
                productDiscountPrice.text = ""
                persentageDiscount.visibility = View.INVISIBLE
            }
            else {
                productOriginalPrice.text = Utils.formatShortPrice(product.dealInfo.originalPrice)
                productOriginalPrice.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 13.0F)
                productOriginalPrice.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
                productOriginalPrice.typeface = Typeface.DEFAULT
                productOriginalPrice.setTextColor(Color.parseColor("#999999"))
                productDiscountPrice.visibility = View.VISIBLE
                productDiscountPrice.setTextColor(Color.parseColor("#D71149"))
                productDiscountPrice.typeface = Typeface.DEFAULT_BOLD
                productDiscountPrice.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16.0F)
                productDiscountPrice.text = Utils.formatShortPrice(product.dealInfo.discountPrice)
                persentageDiscount.visibility = View.VISIBLE
                persentageDiscount.text = product.dealInfo.percentageDiscount.toString()+"%"
            }
            Glide.with(view.context).load(product.smallImages.get(0).toString()).into(imageProduct)
        }
    }
}