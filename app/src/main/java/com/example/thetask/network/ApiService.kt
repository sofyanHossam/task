package com.example.thetask.network

import com.example.thetask.model.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

// ApiService.kt
interface ApiService {

    @GET("posts")
    suspend fun getPosts(): Response<List<Post>>

    @GET("posts/{postId}")
    suspend fun getPostById(@Path("postId") postId: Int): Response<Post>
}
