package com.example.githubclientapp

import android.app.Application
import android.content.Context
import com.example.githubclientapp.di.AppDependenciesComponent
import com.example.githubclientapp.di.AppDependenciesModule
import com.example.githubclientapp.di.DaggerAppDependenciesComponent

class App : Application() {
    lateinit var appDependenciesComponent: AppDependenciesComponent

    override fun onCreate() {
        super.onCreate()
        appDependenciesComponent = DaggerAppDependenciesComponent
            .builder()
            .appDependenciesModule(AppDependenciesModule())
            .build()
    }
}

val Context.app: App
    get() {
        return applicationContext as App
    }
