package com.example.fragmentsapp.VM

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fragmentsapp.model.Movie
import com.example.fragmentsapp.model.MovieResponse
import com.example.fragmentsapp.services.MovieApiInterface
import com.example.fragmentsapp.services.MovieApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel():ViewModel(){

    private val _popularMovies = MutableLiveData<List<Movie>>()
    val popularMovies = _popularMovies

    private val _favoriteMovies = MutableLiveData<List<Movie>>()
    val favoriteMovies = _favoriteMovies

    private val favoriteMovieList = mutableListOf<Movie>()

    fun getPopular(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                getMovieData { movies : List<Movie> -> _popularMovies.value = movies }
            }
        }
    }

    fun updateFavorites(movie:Movie){
       favoriteMovieList.add(movie)
        _favoriteMovies.value = favoriteMovieList
    }

    private fun getMovieData(callback:(List<Movie>) -> Unit){
        val apiService = MovieApiService.getInstance().create(MovieApiInterface::class.java)
        apiService.getPopularList().enqueue(object: Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                return callback(response.body()!!.movies)
            }
        })
    }
}
