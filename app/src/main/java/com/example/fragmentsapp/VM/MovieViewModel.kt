package com.example.fragmentsapp.VM

import android.app.Application
import androidx.lifecycle.*
import androidx.room.Room
import com.example.fragmentsapp.model.*
import com.example.fragmentsapp.services.MovieApiInterface
import com.example.fragmentsapp.services.MovieApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel(application: Application) : AndroidViewModel(application){
    private val context = getApplication<Application>().applicationContext
    private val _popularMovies = MutableLiveData<List<Movie>>()
    val popularMovies = _popularMovies

    private val _favoriteMovies = MutableLiveData<List<Movie>>()
    val favoriteMovies = _favoriteMovies

    val db = Room.databaseBuilder(
        context,
        MovieDatabase::class.java, "database-name"
    ).build()

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

    suspend fun loadToDb(){
        db.MovieDao().insertAll(_popularMovies.value!!.map { it.toDatabase() })
    }
    suspend fun getFav(): List<MovieEntity> {
        return db.MovieDao().getAllFavMovies()
    }

}
