package com.example.githubclientapp

import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment
import com.example.githubclientapp.data.RetrofitGithubUserApiImpl
import com.example.githubclientapp.domain.repository.GithubUserRepository
import com.example.githubclientapp.utils.ViewModelStore

class App : Application() {

    val githubUserApi: GithubUserRepository by lazy { RetrofitGithubUserApiImpl() }
    val viewModelStore by lazy { ViewModelStore() }

}

val Context.app: App
    get() = applicationContext as App

val Fragment.app: App
    get() = requireActivity().app