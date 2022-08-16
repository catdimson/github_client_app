package com.example.githubclientapp.ui.viewmodel.userdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.githubclientapp.data.GithubApi

class UserDetailViewModelFactory(private val usersRepo: GithubApi) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserDetailViewModel(usersRepo) as T
    }
}