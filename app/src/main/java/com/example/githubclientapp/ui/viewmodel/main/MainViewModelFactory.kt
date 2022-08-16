package com.example.githubclientapp.ui.viewmodel.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.githubclientapp.domain.repository.GithubUserRepository

class MainViewModelFactory(private val usersRepo: GithubUserRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(usersRepo) as T
    }
}