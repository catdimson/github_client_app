package com.example.githubclientapp

import android.app.Application
import android.content.Context
import com.example.githubclientapp.data.RetrofitGithubUserApiImpl
import com.example.githubclientapp.domain.repository.GithubUserRepository

class App : Application() {

    val githubUserApi: GithubUserRepository by lazy { RetrofitGithubUserApiImpl() }

}

val Context.app: App
    get() = applicationContext as App