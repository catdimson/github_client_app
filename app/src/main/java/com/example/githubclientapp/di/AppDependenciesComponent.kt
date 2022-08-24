package com.example.githubclientapp.di

import com.example.githubclientapp.ui.viewmodel.userdetail.UserDetailViewModel
import com.example.githubclientapp.ui.viewmodel.userlist.UserListViewModel
import com.example.githubclientapp.utils.ViewModelStore
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppDependenciesModule::class
    ]
)
interface AppDependenciesComponent {

    fun getUserDetailViewModel(): UserDetailViewModel

    fun getUserListViewModel(): UserListViewModel

    fun getViewModelStore(): ViewModelStore

}