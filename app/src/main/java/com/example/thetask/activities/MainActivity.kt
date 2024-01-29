package com.example.thetask.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.thetask.R
import com.example.thetask.adapter.PostAdapter
import com.example.thetask.viewModel.PostViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var postViewModel: PostViewModel
    private lateinit var postAdapter: PostAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        postAdapter = PostAdapter{ id ->
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("PostId", id)
            startActivity(intent)

        }

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = postAdapter

        postViewModel = ViewModelProvider(this)[PostViewModel::class.java]
        postViewModel.posts.observe(this, Observer { posts ->
            posts?.let {
                postAdapter.setPosts(it)
            }
        })

        postViewModel.getPosts()

        postViewModel.toastMessage.observe(this, { message ->
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        })


    }
}