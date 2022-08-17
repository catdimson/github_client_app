package com.example.githubclientapp.domain.entities

import com.google.gson.annotations.SerializedName

data class GithubUser(
    val id: Int,
    val login: String,
    @SerializedName("avatar_url")
    val avatarUrl: String
)