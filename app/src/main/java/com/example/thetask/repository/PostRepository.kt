package com.example.thetask.repository

import com.example.thetask.model.Post
import com.example.thetask.network.ApiService
import retrofit2.Response
import javax.inject.Inject

// PostRepository.kt
class PostRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getPosts(): Response<List<Post>> {
        return apiService.getPosts()
    }
    suspend fun getPostById(postId: Int): Response<Post> {
        return apiService.getPostById(postId)
    }
}
