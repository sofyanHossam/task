package com.example.thetask.data.repository

import com.example.thetask.data.model.Post
import com.example.thetask.data.network.ApiService
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
