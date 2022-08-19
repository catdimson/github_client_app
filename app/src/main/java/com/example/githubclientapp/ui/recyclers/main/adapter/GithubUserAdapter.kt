package com.example.githubclientapp.ui.recyclers.main.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.githubclientapp.domain.entities.GithubUser
import com.example.githubclientapp.ui.recyclers.main.viewholder.GithubUserViewHolder

class GithubUserAdapter(
    private val itemClickCallback: (GithubUser) -> Unit
) : RecyclerView.Adapter<GithubUserViewHolder>() {

    private var data: List<GithubUser> = emptyList()

    fun setData(users: List<GithubUser>) {
        data = users
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubUserViewHolder =
        GithubUserViewHolder.create(parent)

    override fun onBindViewHolder(holder: GithubUserViewHolder, position: Int) {
        holder.bind(getItem(position), itemClickCallback)
    }

    override fun getItemCount(): Int = data.size

    private fun getItem(pos: Int): GithubUser = data[pos]


}