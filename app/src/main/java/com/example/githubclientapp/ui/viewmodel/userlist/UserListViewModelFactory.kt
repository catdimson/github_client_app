package com.example.githubclientapp.ui.viewmodel.userlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.githubclientapp.domain.repository.GithubUserRepository

class UserListViewModelFactory(private val usersRepo: GithubUserRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserListViewModel(usersRepo) as T
    }
}