package com.example.githubclientapp.di

import com.example.githubclientapp.data.GithubApi
import com.example.githubclientapp.data.RetrofitGithubUserApiImpl
import com.example.githubclientapp.domain.repository.GithubUserRepository
import com.example.githubclientapp.ui.viewmodel.userdetail.UserDetailViewModel
import com.example.githubclientapp.ui.viewmodel.userlist.UserListViewModel
import com.example.githubclientapp.utils.ViewModelStore
import dagger.Module
import dagger.Provides
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppDependenciesModule {

    @Provides
    fun provideUserDetailViewModel(githubUserRepository: GithubUserRepository): UserDetailViewModel {
        return UserDetailViewModel(githubUserRepository)
    }

    @Provides
    fun provideUserListViewModel(githubUserRepository: GithubUserRepository): UserListViewModel {
        return UserListViewModel(githubUserRepository)
    }

    @Singleton
    @Provides
    fun provideGithubUserRepository(api: GithubApi): GithubUserRepository {
        return RetrofitGithubUserApiImpl(api)
    }

    @Singleton
    @Provides
    fun provideGithubApi(retrofit: Retrofit): GithubApi {
        return retrofit.create(GithubApi::class.java)
    }

    @Provides
    fun provideBaseUrl(): String {
        return "https://api.github.com/"
    }

    @Provides
    fun provideConverterFactory(): Converter.Factory {
        return GsonConverterFactory.create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(baseUrl: String, converterFactory: Converter.Factory): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(converterFactory)
            .build()
    }

    @Singleton
    @Provides
    fun getViewModelStore(): ViewModelStore {
        return ViewModelStore()
    }
}
