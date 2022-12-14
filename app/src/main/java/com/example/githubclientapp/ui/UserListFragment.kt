package com.example.githubclientapp.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubclientapp.R
import com.example.githubclientapp.app
import com.example.githubclientapp.databinding.FragmentUserListBinding
import com.example.githubclientapp.domain.entities.GithubUser
import com.example.githubclientapp.ui.recyclers.main.adapter.GithubUserAdapter
import com.example.githubclientapp.ui.viewmodel.userlist.UserListViewModel
import com.example.githubclientapp.utils.ViewModelStore

const val VM_USER_LIST_ID = "VM_USER_LIST_ID"

class UserListFragment : Fragment(R.layout.fragment_user_list) {

    lateinit var viewModelStore: ViewModelStore
    lateinit var viewModel: UserListViewModel

    private var _binding: FragmentUserListBinding? = null
    private val binding: FragmentUserListBinding
        get() = _binding!!
    private val controller by lazy { activity as Controller }
    private val adapter = GithubUserAdapter {
        controller.openUserDetailFragment(it)
    }

    override fun onAttach(context: Context) {
        val diComponent = requireActivity().app.appDependenciesComponent
        viewModelStore = diComponent.getViewModelStore()
        viewModel = diComponent.getUserListViewModel()
        super.onAttach(context)
        if (activity !is Controller) {
            throw IllegalStateException("Activity должна наследоваться от UserListFragment.Controller")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState != null) {
            val vmID = savedInstanceState.getString(VM_USER_LIST_ID)!!
            viewModel = viewModelStore.getViewModel(vmID) as UserListViewModel
        } else {
            viewModelStore.saveViewModel(viewModel)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentUserListBinding.bind(view)

        initView()
        initIncomingEvents()
        initOutgoingEvents()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(VM_USER_LIST_ID, viewModel.vmID)
    }

    private fun initView() {
        binding.listUsersRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.listUsersRecyclerView.adapter = adapter
    }

    private fun initOutgoingEvents() {
        viewModel.onShowUsers()
    }

    private fun initIncomingEvents() {
        viewModel.usersLiveDataToObserve.observe(requireActivity()) {
            adapter.setData(it)
        }
        viewModel.showProgressBar.observe(requireActivity()) { inProgress ->
            binding.loader.loadingLayout.isVisible = inProgress
        }
    }

    interface Controller {
        fun openUserDetailFragment(userDetail: GithubUser)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}