package com.learnandroid5.adapter

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.OrientationHelper
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.learnandroid5.R
import com.learnandroid5.model.Popular

class PopularSectionAdapter(val populars : ArrayList<Popular>, var context: Context) : RecyclerView.Adapter<PopularSectionAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(populars.get(position), context)
    }

    override fun getItemCount() = populars.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.popular_section, parent, false)
        return ViewHolder(view)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private var view : View = itemView
        private var popular : Popular? = null
        private var rvPopularProduct = view.findViewById(R.id.rvPopularProducts) as RecyclerView
        private var popularTitle = view.findViewById(R.id.populars_title_list) as TextView

        override fun onClick(p0: View?) {
            Toast.makeText(view.context, "Item diklik", Toast.LENGTH_LONG).show()
        }

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(popular: Popular, context: Context) {
            this.popular = popular
            //if(popular.title!=""&&popular.campign_id!=null){
                popularTitle.setText(popular.title)
            //}
            rvPopularProduct.layoutManager = LinearLayoutManager(context, OrientationHelper.HORIZONTAL, false)
            rvPopularProduct.adapter = PopularProductAdapter(popular.products)
        }
    }
}