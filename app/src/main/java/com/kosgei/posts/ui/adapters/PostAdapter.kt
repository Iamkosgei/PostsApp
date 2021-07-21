package com.kosgei.posts.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kosgei.posts.data.models.Post
import com.kosgei.posts.databinding.PostItemBinding


class PostAdapter(posts: List<Post>) : RecyclerView.Adapter<PostAdapter.PostsViewHolder>() {

    private val posts = mutableListOf<Post>()

    init {
        this.posts.addAll(posts)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostAdapter.PostsViewHolder {
        return PostsViewHolder(
            PostItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PostAdapter.PostsViewHolder, position: Int) {
        holder.setPost(posts[position])
    }

    class PostsViewHolder(private val postItemBinding: PostItemBinding) :
        RecyclerView.ViewHolder(postItemBinding.root) {
            fun setPost(post: Post){
                postItemBinding.post =post
            }

    }

    fun setPosts(posts: List<Post>) {
        val diffCallback = PostDiffUtil(this.posts, posts)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        this.posts.clear()
        this.posts.addAll(posts)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun getItemCount(): Int {
        return posts.size
    }
}
