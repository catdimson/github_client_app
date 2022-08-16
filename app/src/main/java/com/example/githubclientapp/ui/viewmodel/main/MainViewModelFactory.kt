package com.example.githubclientapp.ui.viewmodel.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.githubclientapp.data.GithubApi

class MainViewModelFactory(private val usersRepo: GithubApi) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(usersRepo) as T
    }
}