package com.example.githubclientapp.ui

import com.example.githubclientapp.domain.entities.GithubUser
import com.example.githubclientapp.domain.entities.GithubUserDetail

sealed class AppState {

    data class SuccessLoadUsers(val githubUsers: List<GithubUser>?) : AppState()

    data class SuccessLoadUserDetail(val githubUserDetail: GithubUserDetail?) : AppState()

    data class Error(val e: Throwable) : AppState()

    data class Loading(val process: Boolean): AppState()

}