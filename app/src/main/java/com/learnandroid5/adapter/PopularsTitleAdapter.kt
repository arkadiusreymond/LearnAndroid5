package com.learnandroid5.adapter

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.OrientationHelper
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.learnandroid5.R
import com.learnandroid5.model.Popular
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.popular_section.view.*

class PopularsTitleAdapter(val populars : ArrayList<Popular>, var context: Context) : RecyclerView.Adapter<PopularsTitleAdapter.MovieViewHolder>() {
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(populars.get(position), context)
    }

    override fun getItemCount() = populars.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.popular_section, parent, false)
        return MovieViewHolder(view)
    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private var view : View = itemView
        private var popular : Popular? = null

        override fun onClick(p0: View?) {
            Toast.makeText(view.context, "Item diklik", Toast.LENGTH_LONG).show()
        }

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(popular: Popular, context: Context) {
            this.popular = popular
            view.rvPopularProducts.layoutManager = LinearLayoutManager(context, OrientationHelper.HORIZONTAL, false)
            view.rvPopularProducts.adapter = ProductsListAdapter(popular.products)
//            val imageUrl = StringBuilder()
//            imageUrl.append(view.context.getString(R.string.base_path_poster)).append(popular.posterPath)
            view.populars_title_list.setText(popular.title)
            Log.d("sad",popular.campign_id.toString())
//            Glide.with(view.context).load(imageUrl.toString()).into(view.mvPoster)
        }
    }
}