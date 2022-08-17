package com.example.githubclientapp.domain.entities

import com.google.gson.annotations.SerializedName

data class GithubRepo(
    val name: String,
    @SerializedName("full_name")
    val fullName: String,
    val description: String
)