package com.example.githubclientapp.ui.recyclers.userdetail.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.githubclientapp.domain.entities.GithubRepo
import com.example.githubclientapp.ui.recyclers.userdetail.viewholder.GithubRepoViewHolder

class GithubRepoAdapter : RecyclerView.Adapter<GithubRepoViewHolder>() {

    private var data: List<GithubRepo> = emptyList()

    fun setData(repos: List<GithubRepo>) {
        data = repos
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubRepoViewHolder =
        GithubRepoViewHolder.create(parent)

    override fun onBindViewHolder(holder: GithubRepoViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemCount(): Int = data.size

    private fun getItem(pos: Int): GithubRepo = data[pos]


}