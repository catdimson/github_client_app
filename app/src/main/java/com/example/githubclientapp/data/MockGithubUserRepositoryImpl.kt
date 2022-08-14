package com.example.githubclientapp.data

import com.example.githubclientapp.domain.entities.GithubUser
import com.example.githubclientapp.domain.entities.GithubUserDetail
import com.example.githubclientapp.domain.repository.GithubUserRepository

class MockGithubUserRepositoryImpl: GithubUserRepository {

    override fun findAll(): List<GithubUser> = getFakeGithubUsersData()

    override fun findByLogin(login: String): GithubUserDetail? = getFakeGithubUserDetail(login)

}

// todo Далее нужно будет убрать заглушку и реализовать реальные обращения в сеть через retrofit
private fun getFakeGithubUsersData(): List<GithubUser> {
    fakeFakeGithubUsersData?.let {
        return fakeFakeGithubUsersData!!
    }
    fakeFakeGithubUsersData = listOf(
        GithubUser(1, "user1"),
        GithubUser(2, "user2"),
        GithubUser(3, "user3"),
        GithubUser(4, "user4"),
        GithubUser(5, "user5"),
        GithubUser(6, "user6"),
    )
    return fakeFakeGithubUsersData!!
}

// todo Далее нужно будет убрать заглушку и реализовать реальные обращения в сеть через retrofit
private fun getFakeGithubUserDetail(login: String): GithubUserDetail? {
    fakeFakeGithubUsersData?.let {

    }
    getFakeGithubUsersData()
    return getFakeGithubUserDetail(login)
}

// todo
private var fakeFakeGithubUsersData: List<GithubUser>? = null
