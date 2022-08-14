package com.example.githubclientapp.ui.viewmodel.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.githubclientapp.domain.repository.GithubUserRepository
import com.example.githubclientapp.ui.AppState

class MainViewModel(
    private val githubUserRepository: GithubUserRepository
): ViewModel() {

    private val _usersLiveDataToObserve = MutableLiveData<AppState>()
    val usersLiveDataToObserve: LiveData<AppState> = _usersLiveDataToObserve

    fun onShowUsers() {
//        _usersLiveDataToObserve.postValue(AppState.Loading(true))
        val listUsers = githubUserRepository.findAll()
        _usersLiveDataToObserve.postValue(AppState.SuccessLoadUsers(listUsers))
//        _usersLiveDataToObserve.postValue(AppState.Loading(false))
    }

}