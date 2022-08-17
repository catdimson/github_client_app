package com.example.githubclientapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.githubclientapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
//    private val viewModel: MainViewModel by viewModels {
//        MainViewModelFactory(app.githubUserApi)
//    }
//    private val adapter = GithubUserAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initFragment()
//        initIncomingEvents()
//        initOutgoingEvents()
    }

//    private fun initIncomingEvents() {
//        viewModel.usersLiveDataToObserve.observe(this) {
//            adapter.setData(it)
//        }
//        viewModel.showProgressBar.observe(this) { inProgress ->
//            binding.loader.loadingLayout.isVisible = inProgress
//        }
//    }
//
//    private fun initOutgoingEvents() {
//        viewModel.onShowUsers()
//    }

    private fun initFragment() {
        val rootFragment: Fragment = UserListFragment()
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(binding.rootFragmentContainer.id, rootFragment)
            .commit()
//        binding.listUsersRecyclerView.layoutManager = LinearLayoutManager(this)
//        adapter.setHasStableIds(true)
//        binding.listUsersRecyclerView.adapter = adapter
    }
}