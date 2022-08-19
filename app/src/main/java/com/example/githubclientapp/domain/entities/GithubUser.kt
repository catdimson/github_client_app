package com.example.githubclientapp.domain.entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GithubUser(
    val id: Int,
    val login: String,
    @SerializedName("avatar_url")
    val avatarUrl: String
): Parcelable