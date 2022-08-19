package com.example.githubclientapp.ui.recyclers.main.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.githubclientapp.databinding.ItemUserBinding
import com.example.githubclientapp.domain.entities.GithubUser

class GithubUserViewHolder(
    private val binding: ItemUserBinding
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun create(parent: ViewGroup): GithubUserViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            return GithubUserViewHolder(ItemUserBinding.inflate(inflater))
        }
    }

    fun bind(item: GithubUser, listener: (GithubUser) -> Unit) {
        binding.userId.text = item.id.toString()
        binding.userLogin.text = item.login
        binding.root.setOnClickListener {
            listener.invoke(item)
        }
    }

}