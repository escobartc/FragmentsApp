package com.example.fragmentsapp.services

import com.example.fragmentsapp.model.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface MovieApiInterface {
    @GET("/3/movie/popular?api_key=043702159929d834ac7fab179dc0d658")
    fun getPopularList(): Call<MovieResponse>

}