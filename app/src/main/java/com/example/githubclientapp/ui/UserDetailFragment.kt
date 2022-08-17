package com.example.githubclientapp.ui

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import coil.api.load
import com.example.githubclientapp.R
import com.example.githubclientapp.app
import com.example.githubclientapp.databinding.FragmentUserDetailBinding
import com.example.githubclientapp.domain.entities.GithubUser
import com.example.githubclientapp.domain.entities.GithubUserDetail
import com.example.githubclientapp.ui.recyclers.userdetail.adapter.GithubRepoAdapter
import com.example.githubclientapp.ui.viewmodel.userdetail.UserDetailViewModel
import com.example.githubclientapp.ui.viewmodel.userdetail.UserDetailViewModelFactory

const val KEY_USER = "KEY_USER"

class UserDetailFragment : Fragment(R.layout.fragment_user_detail) {
    private var _binding: FragmentUserDetailBinding? = null
    private val binding: FragmentUserDetailBinding
        get() = _binding!!
    private val viewModel: UserDetailViewModel by viewModels {
        UserDetailViewModelFactory(app.githubUserApi)
    }
    private val adapter = GithubRepoAdapter()

    companion object {
        fun newInstance(userDetail: GithubUser): UserDetailFragment {
            val userDetailFragment = UserDetailFragment()
            userDetailFragment.arguments = Bundle()
            userDetailFragment.arguments?.putParcelable(KEY_USER, userDetail)
            return userDetailFragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentUserDetailBinding.bind(view)

        initView()
        initIncomingEvents()
        initOutgoingEvents(getUserFromArgs())
    }

    private fun getUserFromArgs(): GithubUser {
        return arguments?.getParcelable(KEY_USER)
            ?: throw IllegalStateException("Не передан аргумент")
    }

    private fun initIncomingEvents() {
        viewModel.userDetailLiveDataToObserve.observe(requireActivity()) { githubUserDetail ->
            setUserDetailFields(githubUserDetail)
            adapter.setData(githubUserDetail.listRepos)
        }
        viewModel.showProgressBar.observe(requireActivity()) { inProgress ->
            binding.loader.loadingLayout.isVisible = inProgress
        }
    }

    private fun initOutgoingEvents(user: GithubUser) {
        viewModel.onShowUserDetail(user.login, user.avatarUrl)
    }

    private fun initView() {
        binding.userReposRecyclerView.layoutManager = LinearLayoutManager(requireContext())
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