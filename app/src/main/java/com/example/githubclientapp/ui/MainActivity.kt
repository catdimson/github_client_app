package com.example.githubclientapp.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubclientapp.app
import com.example.githubclientapp.databinding.ActivityMainBinding
import com.example.githubclientapp.ui.recyclers.adapter.GithubUserAdapter
import com.example.githubclientapp.ui.viewmodel.main.MainViewModel
import com.example.githubclientapp.ui.viewmodel.main.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels {
        MainViewModelFactory(app.githubUserRepository)
    }
    private val adapter = GithubUserAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
        initIncomingEvents()
        initOutgoingEvents()
    }

    private fun initIncomingEvents() {
        viewModel.usersLiveDataToObserve.observe(this) {
            adapter.setData(it)
        }
        viewModel.showProgressBar.observe(this) { inProgress ->
            activateProgressBar(inProgress)
        }
    }

    private fun initOutgoingEvents() {
        viewModel.onShowUsers()
    }

    private fun initViews() {
        binding.listUsersRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter.setHasStableIds(true)
        binding.listUsersRecyclerView.adapter = adapter
    }

    private fun activateProgressBar(activate: Boolean) {
        with(binding.loader.loadingLayout) {
            isVisible = activate
        }
    }
}