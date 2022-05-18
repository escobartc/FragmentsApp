package com.example.fragmentsapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.fragmentsapp.R
import com.example.fragmentsapp.vm.MovieViewModel
import kotlinx.android.synthetic.main.activity_movies.*

class MoviesActivity : AppCompatActivity(R.layout.activity_movies) {


    val movieViewModel : MovieViewModel by viewModels()

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