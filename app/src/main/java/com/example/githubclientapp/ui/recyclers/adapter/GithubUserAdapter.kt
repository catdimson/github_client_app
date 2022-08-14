package com.example.githubclientapp.ui.recyclers.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.githubclientapp.domain.entities.GithubUser
import com.example.githubclientapp.ui.recyclers.veiwholder.GithubUserViewHolder

class GithubUserAdapter: RecyclerView.Adapter<GithubUserViewHolder>() {

    private var data: List<GithubUser> = emptyList()

    fun setData(users: List<GithubUser>) {
        data = users
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubUserViewHolder = GithubUserViewHolder.create(parent)

    override fun onBindViewHolder(holder: GithubUserViewHolder, position: Int) = holder.bind(getItem(position))

    override fun getItemCount(): Int = data.size

    private fun getItem(pos: Int): GithubUser = data[pos]

}