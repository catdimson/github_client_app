package com.example.githubclientapp.domain.repository;

import com.example.githubclientapp.domain.entities.GithubUser;
import com.example.githubclientapp.domain.entities.GithubUserDetail;

import io.reactivex.rxjava3.core.Single;

interface GithubUserRepository {

    fun observeUsers(): Single<List<GithubUser>>

    fun observeRepo(login: String): Single<GithubUserDetail?>

}
