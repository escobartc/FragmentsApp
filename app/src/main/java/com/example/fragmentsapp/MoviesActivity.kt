package com.example.fragmentsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fragmentsapp.model.Movie
import com.example.fragmentsapp.model.MovieResponse
import com.example.fragmentsapp.services.MovieApiInterface
import com.example.fragmentsapp.services.MovieApiService
import kotlinx.android.synthetic.main.activity_movies.*
import kotlinx.android.synthetic.main.fragment_movies.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesActivity : AppCompatActivity(R.layout.activity_movies) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpTabs()

    }

private fun setUpTabs(){
    val adapter = VPAdapter(supportFragmentManager)
    adapter.addFragment(MoviesFragment(),"Popular")
    adapter.addFragment(FavMoviesFragment(),"Favorites")
    viewpager.adapter = adapter
    tablayout.setupWithViewPager(viewpager)

}


}