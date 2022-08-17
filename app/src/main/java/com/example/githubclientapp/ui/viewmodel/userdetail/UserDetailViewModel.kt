package com.example.githubclientapp.ui.viewmodel.userdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.githubclientapp.domain.entities.GithubUserDetail
import com.example.githubclientapp.domain.repository.GithubUserRepository
import com.example.githubclientapp.ui.viewmodel.ViewModelWithId
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.subscribeBy

class UserDetailViewModel(
    private val githubUserApi: GithubUserRepository,
    override val id: String
) : ViewModel(), ViewModelWithId {
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    private val _userDetailLiveDataToObserve = MutableLiveData<GithubUserDetail>()
    private val _showProgressBar = MutableLiveData<Boolean>()
    val userDetailLiveDataToObserve: LiveData<GithubUserDetail> = _userDetailLiveDataToObserve
    val showProgressBar: LiveData<Boolean> = _showProgressBar

    fun onShowUserDetail(login: String, avatarUrl: String) {
        compositeDisposable.add(
            githubUserApi
                .observeRepo(login)
                .subscribeBy {
                    val userDetail = GithubUserDetail(login, avatarUrl, it)
                    _userDetailLiveDataToObserve.postValue(userDetail)
                    _showProgressBar.postValue(false)
                }
        )
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}