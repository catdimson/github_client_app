package com.example.githubclientapp.ui.viewmodel.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.githubclientapp.domain.entities.GithubUser
import com.example.githubclientapp.data.GithubApi

class MainViewModel(
    private val githubUserApi: GithubApi
) : ViewModel() {

    private val _usersLiveDataToObserve = MutableLiveData<List<GithubUser>>()
    private val _showProgressBar = MutableLiveData<Boolean>()
    val usersLiveDataToObserve: LiveData<List<GithubUser>> = _usersLiveDataToObserve
    val showProgressBar: LiveData<Boolean> = _showProgressBar

    fun onShowUsers() {
        val listUsers = githubUserApi.findAll()
        _usersLiveDataToObserve.postValue(listUsers)
        Thread { // имитация работы в сети
            Thread.sleep(1_500)
            _showProgressBar.postValue(false)
        }.start()
    }
}