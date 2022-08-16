package com.example.githubclientapp

import android.app.Application
import android.content.Context
import com.example.githubclientapp.data.GithubApi
import com.example.githubclientapp.data.RetorfitGithubUserApiImpl

class App : Application() {

    val githubUserApi: GithubApi by lazy { RetorfitGithubUserApiImpl() }

}

val Context.app: App
    get() = applicationContext as App