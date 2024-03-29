package com.example.fragmentsapp.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    @SerializedName("id")
    val id : String?,
    @SerializedName("title")
    val title : String?,
    @SerializedName("overview")
    val overview : String?,
    @SerializedName("poster_path")
    val poster : String?,
    @SerializedName("release_date")
    val release : String?,
    var isFavourite : Boolean



) : Parcelable {
    constructor() : this("","","","","", false)
     }