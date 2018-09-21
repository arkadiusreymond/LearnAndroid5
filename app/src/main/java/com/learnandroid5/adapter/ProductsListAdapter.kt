package com.learnandroid5.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.learnandroid5.R
import com.learnandroid5.model.Product

class ProductsListAdapter(val products : ArrayList<Product>) : RecyclerView.Adapter<ProductsListAdapter.MovieViewHolder>() {
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(products.get(position))
    }

    override fun getItemCount() = products.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return MovieViewHolder(view)
    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private var view : View = itemView
        private var product : Product? = null

        override fun onClick(p0: View?) {
            Toast.makeText(view.context, "Item diklik", Toast.LENGTH_LONG).show()
        }

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(product: Product) {
            this.product = product
//            val imageUrl = StringBuilder()
//            imageUrl.append(view.context.getString(R.string.base_path_poster)).append(popular.posterPath)
            var productName = view.findViewById(R.id.nama_product) as TextView
            productName.text = product.name
//            view.nama_product.setText(product.name)
//            Log.d("sad",popular.campign_id.toString())
//            Glide.with(view.context).load(imageUrl.toString()).into(view.mvPoster)
        }
    }
}