package com.example.githubclientapp.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
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
        viewModel.usersLiveDataToObserve.observe(this) { data ->
            when (data) {
                is AppState.SuccessLoadUsers -> {
                    val githubUsers = data.githubUsers
                    adapter.setData(githubUsers!!)
                    print("Успех")
                }
                is AppState.Loading -> {
                    //todo скрывать/показывать прогресс бар
                    print("Загрузка")
                }
                is AppState.Error -> {
                    //todo будет обработка ошибки
                    print("Ошибка")
                }
            }
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
}