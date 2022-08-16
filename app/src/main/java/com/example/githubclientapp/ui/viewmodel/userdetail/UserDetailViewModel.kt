package com.example.githubclientapp.ui.viewmodel.userdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.githubclientapp.domain.entities.GithubUserDetail
import com.example.githubclientapp.data.GithubApi

class UserDetailViewModel(
    private val githubUserApi: GithubApi
) : ViewModel() {

    private val _userDetailLiveDataToObserve = MutableLiveData<GithubUserDetail>()
    val userDetailLiveDataToObserve: LiveData<GithubUserDetail> = _userDetailLiveDataToObserve

    fun onShowUserDetail(login: String) {
        val userDetail = githubUserApi.findByLogin(login)
        userDetail.let {
//            _userDetailLiveDataToObserve.postValue(userDetail)
        }
    }
}