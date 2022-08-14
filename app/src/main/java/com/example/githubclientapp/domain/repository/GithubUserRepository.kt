package com.example.githubclientapp.domain.repository

import com.example.githubclientapp.domain.entities.GithubUser
import com.example.githubclientapp.domain.entities.GithubUserDetail

interface GithubUserRepository {

    fun findAll(): List<GithubUser>

    fun findById(): GithubUserDetail

}