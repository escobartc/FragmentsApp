package com.example.fragmentsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fragmentsapp.model.Movie
import kotlinx.android.synthetic.main.movie_item.view.*

class MovieAdapter (
    private val movies : List<Movie>,
    val movieListener: OnMovieListener
        ) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){
            class MovieViewHolder(view: View,val movieListener: OnMovieListener) : RecyclerView.ViewHolder(view){
                private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
                fun bindMovie(movie:Movie){
                    itemView.movie_title.text = movie.title
                    itemView.Overview.text = movie.overview
                    itemView.imageButton.setOnClickListener {
                        movieListener.onMovieFavoriteClicked(movie)
                    }
                    Glide.with(itemView).load(IMAGE_BASE + movie.poster).into(itemView.movie_poster)
                }
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.movie_item,parent,false), movieListener)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindMovie(movies.get(position))
    }

    override fun getItemCount(): Int = movies.size
}

interface OnMovieListener {
    fun onMovieFavoriteClicked(movie: Movie)
}