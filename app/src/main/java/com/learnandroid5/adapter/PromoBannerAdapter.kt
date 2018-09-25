package com.learnandroid5.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.learnandroid5.R
import com.learnandroid5.model.PromoBanner

class PromoBannerAdapter(val promoBanner : ArrayList<PromoBanner>, var context: Context) : RecyclerView.Adapter<PromoBannerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.promo_baner_item, parent, false)
        return PromoBannerAdapter.ViewHolder(view)
    }

    override fun getItemCount() = promoBanner.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(promoBanner.get(position))
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private var view : View = itemView
        private var promoBanner : PromoBanner? = null
        var imagePromoBanner = view.findViewById<ImageView>(R.id.image_promo_banner)
        var desccriptionPromo = view.findViewById<TextView>(R.id.description_promo)


        override fun onClick(p0: View?) {
            Toast.makeText(view.context, "Item diklik", Toast.LENGTH_LONG).show()
        }

        fun bind(promoBanner : PromoBanner) {
            this.promoBanner = promoBanner
            desccriptionPromo.text = promoBanner.description
            Log.d("sdfsdf", promoBanner.description)
            Glide.with(view.context).load(promoBanner.image).into(imagePromoBanner)
        }
    }
}