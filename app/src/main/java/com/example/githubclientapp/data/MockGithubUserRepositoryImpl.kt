package com.example.githubclientapp.data

import com.example.githubclientapp.domain.entities.GithubRepo
import com.example.githubclientapp.domain.entities.GithubUser
import com.example.githubclientapp.domain.entities.GithubUserDetail
import com.example.githubclientapp.domain.repository.GithubUserRepository

class MockGithubUserRepositoryImpl: GithubUserRepository {

    override fun findAll(): List<GithubUser> = getFakeGithubUsersData()

    override fun findByLogin(login: String): GithubUserDetail? = getFakeGithubUserDetailsData(login)

}

// todo Далее нужно будет убрать заглушку и реализовать реальные обращения в сеть через retrofit
private fun getFakeGithubUsersData(): List<GithubUser> {
    fakeGithubUsersData?.let {
        return fakeGithubUsersData!!
    }
    fakeGithubUsersData = listOf(
        GithubUser(1, "user1"),
        GithubUser(2, "user2"),
        GithubUser(3, "user3"),
        GithubUser(4, "user4"),
        GithubUser(5, "user5"),
        GithubUser(6, "user6"),
    )
    return fakeGithubUsersData!!
}

// todo Далее нужно будет убрать заглушку и реализовать реальные обращения в сеть через retrofit
private fun getFakeGithubUserDetailsData(login: String): GithubUserDetail? {
    fakeGithubUserDetailsData?.let {
        fakeGithubUserDetailsData!!.forEach { user ->
            if (user.login == login) {
                return user
            }
        }
        return null
    }
    fakeGithubUserDetailsData = listOf(
        GithubUserDetail(1, "user1", "https://url1.ru",
            listOf(
                GithubRepo(1, "Hello-world1", "full-Hello-world1", "description1", "https://repo-url1.ru"),
                GithubRepo(2, "Hello-world2", "full-Hello-world2", "description2", "https://repo-url2.ru"),
                GithubRepo(3, "Hello-world3", "full-Hello-world3", "description3", "https://repo-url3.ru"),
                GithubRepo(4, "Hello-world4", "full-Hello-world4", "description4", "https://repo-url4.ru"),
            )
        ),
        GithubUserDetail(2, "user2", "https://url2.ru",
            listOf(
                GithubRepo(5, "Hello-world5", "full-Hello-world5", "description5", "https://repo-url5.ru"),
                GithubRepo(6, "Hello-world6", "full-Hello-world6", "description6", "https://repo-url6.ru"),
                GithubRepo(7, "Hello-world7", "full-Hello-world7", "description7", "https://repo-url7.ru"),
                GithubRepo(8, "Hello-world8", "full-Hello-world8", "description8", "https://repo-url8.ru"),
            )
        ),
        GithubUserDetail(3, "user3", "https://url3.ru",
            listOf(
                GithubRepo(9, "Hello-world9", "full-Hello-world9", "description9", "https://repo-url9.ru"),
                GithubRepo(10, "Hello-world10", "full-Hello-world10", "description10", "https://repo-url10.ru"),
                GithubRepo(11, "Hello-world11", "full-Hello-world11", "description11", "https://repo-url11.ru"),
                GithubRepo(12, "Hello-world12", "full-Hello-world12", "description12", "https://repo-url12.ru"),
            )
        ),
        GithubUserDetail(4, "user4", "https://url4.ru",
            listOf(
                GithubRepo(13, "Hello-world13", "full-Hello-world13", "description13", "https://repo-url13.ru"),
                GithubRepo(14, "Hello-world14", "full-Hello-world14", "description14", "https://repo-url14.ru"),
                GithubRepo(15, "Hello-world15", "full-Hello-world15", "description15", "https://repo-url15.ru"),
                GithubRepo(16, "Hello-world16", "full-Hello-world16", "description16", "https://repo-url16.ru"),
            ))
    )
    return getFakeGithubUserDetailsData(login)
}

// todo Убрать это, когда подключим retrofit
private var fakeGithubUsersData: List<GithubUser>? = null

// todo Убрать это, когда подключим retrofit
private var fakeGithubUserDetailsData: List<GithubUserDetail>? = null
