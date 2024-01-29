package com.example.thetask.presention.activities

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.thetask.R
import com.example.thetask.presention.viewModel.PostViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsActivity : AppCompatActivity() {
    private lateinit var postViewModel: PostViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val postId = intent.getIntExtra("PostId", -1)

        postViewModel = ViewModelProvider(this)[PostViewModel::class.java]
        if (postId != -1) {
            postViewModel.getPostById(postId)
            observePostDetails()
        } else {
            Log.e("Details","No Id Response")
            Toast.makeText(this, "No Id Response", Toast.LENGTH_SHORT).show()

        }

        postViewModel.toastMessage.observe(this, { message ->
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        })
    }

    private fun observePostDetails() {
        postViewModel.selectedPost.observe(this, { post ->
            // Update UI with post details
            val titleTextView: TextView = findViewById(R.id.titleTextView)
            val bodyTextView: TextView = findViewById(R.id.bodyTextView)

            titleTextView.text = post.title
            bodyTextView.text = post.body
        })
    }
}