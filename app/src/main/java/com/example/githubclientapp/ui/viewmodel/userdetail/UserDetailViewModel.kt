package com.example.githubclientapp.ui.viewmodel.userdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.githubclientapp.domain.entities.GithubUserDetail
import com.example.githubclientapp.domain.repository.GithubUserRepository

class UserDetailViewModel(
    private val githubUserRepository: GithubUserRepository
): ViewModel() {

    private val _userDetailLiveDataToObserve = MutableLiveData<GithubUserDetail>()
    val userDetailLiveDataToObserve: LiveData<GithubUserDetail> = _userDetailLiveDataToObserve

    fun onShowUserDetail(login: String) {
        val userDetail = githubUserRepository.findByLogin(login)
        userDetail.let {
            _userDetailLiveDataToObserve.postValue(userDetail)
        }
    }
}