package com.example.githubclientapp.data

import com.example.githubclientapp.domain.entities.GithubRepo
import com.example.githubclientapp.domain.entities.GithubUser
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubApi {
    @GET("users")
    fun findAll(): Single<List<GithubUser>>

    @GET("users/{login}/repos")
    fun findByLogin(@Path("login") login: String): Single<List<GithubRepo>>
}