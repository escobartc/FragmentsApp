package com.example.fragmentsapp.model

import android.content.Context
import androidx.room.Room

class DataSource() {
    val db by lazy { Room.databaseBuilder(applicationContext, MovieDatabase::class.java, "movie-database").build() }
    companion object {
        lateinit var applicationContext : Context
    }
}