//package com.example.githubclientapp.ui
//
//import android.os.Bundle
//import androidx.activity.viewModels
//import androidx.appcompat.app.AppCompatActivity
//import androidx.recyclerview.widget.LinearLayoutManager
//import com.example.githubclientapp.app
//import com.example.githubclientapp.databinding.ActivityUserDetailBinding
//import com.example.githubclientapp.domain.entities.GithubUserDetail
//import com.example.githubclientapp.ui.recyclers.userdetail.adapter.GithubRepoAdapter
//import com.example.githubclientapp.ui.viewmodel.userdetail.UserDetailViewModel
//import com.example.githubclientapp.ui.viewmodel.userdetail.UserDetailViewModelFactory
//
//const val KEY_USER_LOGIN = "KEY_USER_LOGIN"
//
//class UserDetailActivity : AppCompatActivity() {
//
//    private lateinit var binding: ActivityUserDetailBinding
//    private val viewModel: UserDetailViewModel by viewModels {
//        UserDetailViewModelFactory(app.githubUserApi)
//    }
//    private val adapter = GithubRepoAdapter()
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityUserDetailBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        initViews()
//        initIncomingEvents()
//        initOutgoingEvents(intent.extras?.get(KEY_USER_LOGIN).toString())
//    }
//
//    private fun initIncomingEvents() {
//        viewModel.userDetailLiveDataToObserve.observe(this) { githubUserDetail ->
//            githubUserDetail?.let {
//                setUserDetailFields(githubUserDetail)
//                adapter.setData(githubUserDetail.listRepos)
//            }
//        }
//    }
//
//    private fun initOutgoingEvents(loginKey: String) {
//        viewModel.onShowUserDetail(loginKey)
//    }
//
//    private fun initViews() {
//        binding.userReposRecyclerView.layoutManager = LinearLayoutManager(this)
//        adapter.setHasStableIds(true)
//        binding.userReposRecyclerView.adapter = adapter
//    }
//
//    private fun setUserDetailFields(githubUserDetail: GithubUserDetail) {
//        with(binding) {
//            userDetailId.text = githubUserDetail.id.toString()
//            userDetailLogin.text = githubUserDetail.login
//        }
//
//    }
//}