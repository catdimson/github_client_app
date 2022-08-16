package com.example.githubclientapp.ui.viewmodel.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.githubclientapp.domain.entities.GithubUser
import com.example.githubclientapp.domain.repository.GithubUserRepository
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.subscribeBy

class MainViewModel(
    private val githubUserApi: GithubUserRepository
) : ViewModel() {
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    private val _usersLiveDataToObserve = MutableLiveData<List<GithubUser>>()
    private val _showProgressBar = MutableLiveData<Boolean>()
    val usersLiveDataToObserve: LiveData<List<GithubUser>> = _usersLiveDataToObserve
    val showProgressBar: LiveData<Boolean> = _showProgressBar

    fun onShowUsers() {
        compositeDisposable.add(
            githubUserApi
                .observeUsers()
                .subscribeBy {
                    _usersLiveDataToObserve.postValue(it)
                    _showProgressBar.postValue(false)
                }
        )
    }
}