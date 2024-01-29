package com.example.thetask.presention.viewModel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thetask.data.model.Post
import com.example.thetask.data.repository.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

// PostViewModel.kt
@HiltViewModel
class PostViewModel @Inject constructor(private val repository: PostRepository) : ViewModel() {

    private val _posts = MutableLiveData<List<Post>>()
    val posts: LiveData<List<Post>> get() = _posts


    private val _selectedPost = MutableLiveData<Post>()
    val selectedPost: LiveData<Post> get() = _selectedPost

    private val _toastMessage = MutableLiveData<String>()
    val toastMessage: LiveData<String> get() = _toastMessage

    fun getPosts() {
        viewModelScope.launch {
            try {
                val response = repository.getPosts()
                if (response.isSuccessful) {
                    _posts.value = response.body()
                } else {
                    showToast("No Response....try again")

                }
            } catch (e: Exception) {

                showToast("error: "+e.message)
            }
        }
    }
    fun getPostById(postId: Int) {
        viewModelScope.launch {
            try {
                val response = repository.getPostById(postId)
                if (response.isSuccessful) {
                    _selectedPost.value = response.body()
                } else {
                    showToast("No Response....try again")
                }
            } catch (e: Exception) {

                showToast("error: "+e.message)
            }
        }
    }

    fun showToast(message: String) {
        _toastMessage.value = message
    }
}
