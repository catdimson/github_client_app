package com.example.githubclientapp.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import coil.api.load
import com.example.githubclientapp.app
import com.example.githubclientapp.databinding.ActivityUserDetailBinding
import com.example.githubclientapp.domain.entities.GithubUserDetail
import com.example.githubclientapp.ui.recyclers.userdetail.adapter.GithubRepoAdapter
import com.example.githubclientapp.ui.viewmodel.userdetail.UserDetailViewModel
import com.example.githubclientapp.ui.viewmodel.userdetail.UserDetailViewModelFactory

const val KEY_USER_LOGIN = "KEY_USER_LOGIN"
const val KEY_USER_URL_AVATAR = "KEY_USER_URL_AVATAR"

class UserDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserDetailBinding
    private val viewModel: UserDetailViewModel by viewModels {
        UserDetailViewModelFactory(app.githubUserApi)
    }
    private val adapter = GithubRepoAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
        initIncomingEvents()
        initOutgoingEvents(
            intent.extras?.get(KEY_USER_LOGIN).toString(),
            intent.extras?.get(KEY_USER_URL_AVATAR).toString()
        )
    }

    private fun initIncomingEvents() {
        viewModel.userDetailLiveDataToObserve.observe(this) { githubUserDetail ->
            setUserDetailFields(githubUserDetail)
            adapter.setData(githubUserDetail.listRepos)
        }
        viewModel.showProgressBar.observe(this) { inProgress ->
            binding.loader.loadingLayout.isVisible = inProgress
        }
    }

    private fun initOutgoingEvents(loginKey: String, avatarUrl: String ) {
        viewModel.onShowUserDetail(loginKey, avatarUrl)
    }

    private fun initViews() {
        binding.userReposRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter.setHasStableIds(true)
        binding.userReposRecyclerView.adapter = adapter
    }

    private fun setUserDetailFields(githubUserDetail: GithubUserDetail) {
        with(binding) {
            userDetailLogin.text = githubUserDetail.login
            userDetailAvatar.load(githubUserDetail.avatarUrl)
        }

    }
}