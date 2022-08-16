package com.example.githubclientapp.data

import com.example.githubclientapp.domain.entities.GithubUser
import com.example.githubclientapp.domain.entities.GithubUserDetail
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubApi {
    @GET("users")
    fun findAll(): Call<List<GithubUser>>

    @GET("users/{login}/repos")
    fun findByLogin(@Path("login") login: String): Call<GithubUserDetail>
}