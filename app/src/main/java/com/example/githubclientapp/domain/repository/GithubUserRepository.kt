package com.example.githubclientapp.domain.repository;

import com.example.githubclientapp.domain.entities.GithubRepo
import com.example.githubclientapp.domain.entities.GithubUser
import io.reactivex.rxjava3.core.Single

interface GithubUserRepository {
    fun observeUsers(): Single<List<GithubUser>>

    fun observeRepo(login: String): Single<List<GithubRepo>>
}
