package com.example.githubclientapp.data

import com.example.githubclientapp.domain.entities.GithubRepo
import com.example.githubclientapp.domain.entities.GithubUser
import com.example.githubclientapp.domain.repository.GithubUserRepository
import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitGithubUserApiImpl : GithubUserRepository {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val api: GithubApi = retrofit.create(GithubApi::class.java)

    override fun observeUsers(): Single<List<GithubUser>> {
        return api.findAll()
    }

    override fun observeRepo(login: String): Single<List<GithubRepo>> {
        return api.findByLogin(login)
    }
}