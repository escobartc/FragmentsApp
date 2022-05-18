package com.example.fragmentsapp.model

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MovieEntity::class],version = 3)
abstract class MovieDatabase : RoomDatabase()
{
    abstract fun MovieDao():MovieDao
}