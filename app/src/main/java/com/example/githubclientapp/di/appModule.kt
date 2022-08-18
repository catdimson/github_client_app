package com.example.githubclientapp.di

import com.example.githubclientapp.data.GithubApi
import com.example.githubclientapp.data.RetrofitGithubUserApiImpl
import com.example.githubclientapp.domain.repository.GithubUserRepository
import com.example.githubclientapp.ui.viewmodel.userdetail.UserDetailViewModel
import com.example.githubclientapp.ui.viewmodel.userlist.UserListViewModel
import com.example.githubclientapp.utils.ViewModelStore
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single(named("base_github_api_url")) { "https://api.github.com/" }
    single<GithubUserRepository> { RetrofitGithubUserApiImpl(get()) }
    single<GithubApi> { get<Retrofit>().create(GithubApi::class.java) }
    single {
        Retrofit.Builder()
            .baseUrl(get<String>(named("base_github_api_url")))
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(get())
            .build()
    }
    factory<Converter.Factory> { GsonConverterFactory.create() }
}

val viewModelsModule = module {
    single { UserDetailViewModel(get()) }
    single { UserListViewModel(get()) }
    single { ViewModelStore() }
}
