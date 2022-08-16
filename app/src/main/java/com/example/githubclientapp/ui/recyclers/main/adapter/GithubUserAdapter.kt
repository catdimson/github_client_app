package com.example.githubclientapp.ui.recyclers.main.adapter

import android.content.Intent
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.githubclientapp.domain.entities.GithubUser
import com.example.githubclientapp.ui.KEY_USER_LOGIN
import com.example.githubclientapp.ui.UserDetailActivity
import com.example.githubclientapp.ui.recyclers.main.viewholder.GithubUserViewHolder

class GithubUserAdapter : RecyclerView.Adapter<GithubUserViewHolder>() {

    private var data: List<GithubUser> = emptyList()

    fun setData(users: List<GithubUser>) {
        data = users
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubUserViewHolder =
        GithubUserViewHolder.create(parent)

    override fun onBindViewHolder(holder: GithubUserViewHolder, position: Int) {
        holder.bind(getItem(position))
//        holder.itemView.setOnClickListener { itemView ->
//            val githubUser = getItem(position)
//            val intent = Intent(holder.itemView.context, UserDetailActivity::class.java)
//            intent.putExtra(KEY_USER_LOGIN, githubUser.login)
//            holder.itemView.context.startActivity(intent)
//        }
    }

    override fun getItemCount(): Int = data.size

    private fun getItem(pos: Int): GithubUser = data[pos]


}