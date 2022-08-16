package com.example.githubclientapp.data

import com.example.githubclientapp.domain.entities.GithubUser
import com.example.githubclientapp.domain.entities.GithubUserDetail
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetorfitGithubUserApiImpl : GithubApi {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val

    override fun findAll(): Call<List<GithubUser>> {
        TODO("Not yet implemented")
    }

    override fun findByLogin(login: String): Call<GithubUserDetail?> {
        TODO("Not yet implemented")
    }
}