package com.example.githubclientapp.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import coil.api.load
import com.example.githubclientapp.R
import com.example.githubclientapp.app
import com.example.githubclientapp.databinding.FragmentUserDetailBinding
import com.example.githubclientapp.domain.entities.GithubUser
import com.example.githubclientapp.domain.entities.GithubUserDetail
import com.example.githubclientapp.ui.recyclers.userdetail.adapter.GithubRepoAdapter
import com.example.githubclientapp.ui.viewmodel.userdetail.UserDetailViewModel
import com.example.githubclientapp.utils.ViewModelStore

const val KEY_USER = "KEY_USER"
const val VM_USER_DETAIL_ID = "VM_USER_DETAIL_ID"

class UserDetailFragment : Fragment(R.layout.fragment_user_detail) {

    lateinit var viewModelStore: ViewModelStore
    lateinit var viewModel: UserDetailViewModel

    private var _binding: FragmentUserDetailBinding? = null
    private val binding: FragmentUserDetailBinding
        get() = _binding!!
    private val adapter = GithubRepoAdapter()

    companion object {
        fun newInstance(userDetail: GithubUser): UserDetailFragment {
            val userDetailFragment = UserDetailFragment()
            userDetailFragment.arguments = Bundle()
            userDetailFragment.arguments?.putParcelable(KEY_USER, userDetail)
            return userDetailFragment
        }
    }

    override fun onAttach(context: Context) {
        val diComponent = requireActivity().app.appDependenciesComponent
        viewModelStore = diComponent.getViewModelStore()
        viewModel = diComponent.getUserDetailViewModel()
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            val vmID = savedInstanceState.getString(VM_USER_DETAIL_ID)!!
            viewModel = viewModelStore.getViewModel(vmID) as UserDetailViewModel
        } else {
            viewModelStore.saveViewModel(viewModel)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentUserDetailBinding.bind(view)

        initView()
        initIncomingEvents()
        initOutgoingEvents(getUserFromArgs())
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(VM_USER_DETAIL_ID, viewModel.vmID)
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
        binding.userReposRecyclerView.adapter = adapter
    }

    private fun setUserDetailFields(githubUserDetail: GithubUserDetail) {
        with(binding) {
            userDetailLogin.text = githubUserDetail.login
            userDetailAvatar.load(githubUserDetail.avatarUrl)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}