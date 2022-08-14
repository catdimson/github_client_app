package com.example.githubclientapp.domain.entities

data class GithubRepo(

    val id: Int,
    val name: String,
    val fullName: String,
    val description: String,
    val url: String

)