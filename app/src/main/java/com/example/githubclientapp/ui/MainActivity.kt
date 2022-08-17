package com.example.githubclientapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.githubclientapp.databinding.ActivityMainBinding
import com.example.githubclientapp.domain.entities.GithubUser

class MainActivity : AppCompatActivity(), UserListFragment.Controller {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            initFragment()
        }
    }

    private fun initFragment() {
        val rootFragment: Fragment = UserListFragment()
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(binding.rootFragmentContainer.id, rootFragment)
            .commit()
    }

    override fun openUserDetailFragment(userDetail: GithubUser) {
        val userDetailFragment = UserDetailFragment.newInstance(userDetail)
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(binding.rootFragmentContainer.id, userDetailFragment)
            .commit()
    }
}