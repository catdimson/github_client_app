package com.example.githubclientapp.ui.recyclers.userdetail.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.githubclientapp.databinding.ItemRepoBinding
import com.example.githubclientapp.databinding.ItemUserBinding
import com.example.githubclientapp.domain.entities.GithubRepo
import com.example.githubclientapp.domain.entities.GithubUser

class GithubRepoViewHolder(
    private val binding: ItemRepoBinding
): RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun create(parent: ViewGroup): GithubRepoViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            return GithubRepoViewHolder(ItemRepoBinding.inflate(inflater))
        }
    }

    fun bind(item: GithubRepo) {
        binding.apply {
            repoId.text = item.id.toString()
            repoName.text = item.name
            repoFullName.text = item.fullName
            repoDescription.text = item.description
        }
    }

}