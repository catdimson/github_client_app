package com.example.githubclientapp.domain.entities

data class GithubUserDetail(
    val id: Int,
    val login: String,
    val avatarUrl: String,
    val listRepos: List<GithubRepo> = emptyList()
)

    

