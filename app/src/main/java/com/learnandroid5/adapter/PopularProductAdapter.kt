package com.learnandroid5.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.learnandroid5.R
import com.learnandroid5.model.Product

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
        var imageProduct = view.findViewById<ImageView>(R.id.image_product)

        override fun onClick(p0: View?) {
            Toast.makeText(view.context, "Item diklik", Toast.LENGTH_LONG).show()
        }

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(product: Product) {
            this.product = product
            productName.text = product.name
//            val imageUrl = StringBuilder()
//            imageUrl.append(view.context.getString(R.string.base_path_poster)).append(popular.posterPath)
//            Glide.with(view.context).load(imageUrl.toString()).into(view.mvPoster)
            Glide.with(view.context).load(product.smallImages.get(0).toString()).into(imageProduct)
        }
    }
}