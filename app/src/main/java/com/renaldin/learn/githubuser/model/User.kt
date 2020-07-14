package com.renaldin.learn.githubuser.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val name: String?,
    val username: String?,
    val company: String?,
    val location: String?,
    val repository: String?,
    val followers: String?,
    val following: String?,
    val photo: Int
) : Parcelable