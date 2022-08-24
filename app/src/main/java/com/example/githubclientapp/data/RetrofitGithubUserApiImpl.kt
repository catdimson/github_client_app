package com.example.githubclientapp.data

import com.example.githubclientapp.domain.entities.GithubRepo
import com.example.githubclientapp.domain.entities.GithubUser
import com.example.githubclientapp.domain.repository.GithubUserRepository
import io.reactivex.rxjava3.core.Single

class RetrofitGithubUserApiImpl(
    private val api: GithubApi
) : GithubUserRepository {

    override fun observeUsers(): Single<List<GithubUser>> {
        return api.findAll()
    }

    override fun observeRepo(login: String): Single<List<GithubRepo>> {
        return api.findByLogin(login)
    }
}