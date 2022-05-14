package com.example.fragmentsapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fragmentsapp.model.Movie

class MovieViewModel():ViewModel(){


    private val users: MutableLiveData<List<Movie>> by lazy {
        MutableLiveData<List<Movie>>().also {
            loadMovies()
        }
    }

    fun getUsers(): LiveData<List<Movie>> {
        return users
    }

    private fun loadMovies() {
        // Do an asynchronous operation to fetch users.
    }
}
