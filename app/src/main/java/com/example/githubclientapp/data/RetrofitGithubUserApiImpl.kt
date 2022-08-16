package com.example.githubclientapp.data

import com.example.githubclientapp.domain.entities.GithubRepo
import com.example.githubclientapp.domain.entities.GithubUser
import com.example.githubclientapp.domain.repository.GithubUserRepository
import io.reactivex.rxjava3.core.Single
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitGithubUserApiImpl : GithubUserRepository {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val api : GithubApi = retrofit.create(GithubApi::class.java)

    override fun observeUsers(): Single<List<GithubUser>> {
        return Single.create { emitter ->
            api.findAll().enqueue(object : Callback<List<GithubUser>> {
                override fun onResponse(
                    call: Call<List<GithubUser>>,
                    response: Response<List<GithubUser>>
                ) {
                    emitter.onSuccess(response.body()!!)
                }

                override fun onFailure(call: Call<List<GithubUser>>, t: Throwable) {
                    emitter.onError(t)
                }
            })
        }
    }

    override fun observeRepo(login: String): Single<List<GithubRepo>> {
        return Single.create { emitter ->
            api.findByLogin(login).enqueue(object : Callback<List<GithubRepo>> {
                override fun onResponse(
                    call: Call<List<GithubRepo>>,
                    response: Response<List<GithubRepo>>
                ) {
                    emitter.onSuccess(response.body()!!)
                }

                override fun onFailure(call: Call<List<GithubRepo>>, t: Throwable) {
                    emitter.onError(t)
                }
            })
        }
    }
}