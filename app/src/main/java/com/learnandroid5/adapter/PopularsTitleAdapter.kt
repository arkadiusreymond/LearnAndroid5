package com.learnandroid5.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.learnandroid5.R
import com.learnandroid5.model.Populars
import kotlinx.android.synthetic.main.movie_list.view.*

class PopularsTitleAdapter(val populars : ArrayList<Populars>) : RecyclerView.Adapter<PopularsTitleAdapter.MovieViewHolder>() {
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(populars.get(position))
    }

    override fun getItemCount() = populars.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_list, parent, false)
        return MovieViewHolder(view)
    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private var view : View = itemView
        private var populars : Populars? = null

        override fun onClick(p0: View?) {
            Toast.makeText(view.context, "Item diklik", Toast.LENGTH_LONG).show()
        }

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(populars: Populars) {
            this.populars = populars
//            val imageUrl = StringBuilder()
//            imageUrl.append(view.context.getString(R.string.base_path_poster)).append(populars.posterPath)
            view.populars_title_list.setText(populars.title)
//            Glide.with(view.context).load(imageUrl.toString()).into(view.mvPoster)
        }
    }
}