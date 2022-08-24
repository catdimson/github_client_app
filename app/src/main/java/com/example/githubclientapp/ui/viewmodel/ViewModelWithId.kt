package com.example.githubclientapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import java.util.*

open class ViewModelWithId : ViewModel() {
    val vmID: String = UUID.randomUUID().toString()
}