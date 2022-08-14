package com.example.githubclientapp

import android.app.Application
import android.content.Context
import com.example.githubclientapp.data.MockGithubUserRepositoryImpl
import com.example.githubclientapp.domain.repository.GithubUserRepository

class App: Application() {

    val githubUserRepository: GithubUserRepository by lazy { MockGithubUserRepositoryImpl() }

}

val Context.app: App
    get() = applicationContext as App