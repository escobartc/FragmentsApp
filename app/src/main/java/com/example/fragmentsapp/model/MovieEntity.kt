package com.example.fragmentsapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movie_table")
data class MovieEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id : Int = 0,
    @ColumnInfo(name = "title")val title : String?,
    @ColumnInfo(name = "overview")val overview : String?,
    @ColumnInfo(name = "poster")val poster : String?,
    @ColumnInfo(name = "release")val release : String?,
    @ColumnInfo(name = "isFavourite")var isFavourite : Boolean
)

fun Movie.toDatabase() = MovieEntity(title = title, overview = overview, poster = poster, release = release, isFavourite = isFavourite)