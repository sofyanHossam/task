package com.example.thetask.presention.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.thetask.databinding.ItemPostBinding
import com.example.thetask.data.model.Post

// PostAdapter.kt
class PostAdapter(private val onItemClickListener: (Int) -> Unit) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    private var posts: List<Post> = emptyList()

    fun setPosts(newPosts: List<Post>) {
        val diffResult = DiffUtil.calculateDiff(PostDiffCallback(posts, newPosts))
        posts = newPosts

        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = ItemPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(posts[position])
        holder.itemView.setOnClickListener {
            onItemClickListener.invoke(posts[position].id)
        }


    }

    override fun getItemCount(): Int = posts.size

    class PostViewHolder(private val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(post: Post) {
            binding.post = post
            binding.executePendingBindings()
        }
    }
}

