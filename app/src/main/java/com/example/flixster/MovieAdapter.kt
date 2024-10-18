package com.example.flixster

import android.content.Context
import android.icu.text.CaseMap.Title
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

private const val TAG = "MovieAdapter"
class MovieAdapter(private val context: Context, private val movies: List<Movie>)
    : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.i(TAG, "onCreateViewHolder")
        val view = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount()=  movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.i(TAG, "onBindViewHolder position $position")
       val movie = movies[position]
        holder.bind(movie)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val Title = itemView.findViewById<TextView>(R.id.Title)
        private val Overview = itemView.findViewById<TextView>(R.id.Overview)
        private val ivPoster= itemView.findViewById<ImageView>(R.id.ivPoster)
        fun bind(movie: Movie){
            Title.text = movie.title
            Overview.text = movie.overview
            Glide.with(context).load(movie.psoterImageUrl).into(ivPoster)


        }
    }

}
