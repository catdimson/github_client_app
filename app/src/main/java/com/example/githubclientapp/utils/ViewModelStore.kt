package com.example.githubclientapp.utils

import com.example.githubclientapp.ui.viewmodel.ViewModelWithId
import java.util.*

class ViewModelStore {
    private val storage: MutableMap<String, ViewModelWithId> = WeakHashMap()

    fun saveViewModel(vm: ViewModelWithId) {
        storage[vm.vmID] = vm
    }

    fun getViewModel(id: String): ViewModelWithId? {
        return storage[id]
    }
}