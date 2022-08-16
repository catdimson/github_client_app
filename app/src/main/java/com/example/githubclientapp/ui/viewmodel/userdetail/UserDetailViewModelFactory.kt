package com.example.githubclientapp.ui.viewmodel.userdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.githubclientapp.domain.repository.GithubUserRepository
import com.example.githubclientapp.ui.viewmodel.main.MainViewModel

class UserDetailViewModelFactory(private val usersRepo: GithubUserRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserDetailViewModel(usersRepo) as T
    }
}