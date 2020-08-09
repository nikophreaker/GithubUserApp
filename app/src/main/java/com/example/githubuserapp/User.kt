package com.example.githubuserapp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User (
    val username: String,
    val name: String,
    val company: String,
    val lokasi: String,
    val repository: String,
    val follower: String,
    val following: String,
    val avatar: Int
): Parcelable