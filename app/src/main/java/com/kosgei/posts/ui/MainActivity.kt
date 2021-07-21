package com.kosgei.posts.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.kosgei.posts.data.models.Post
import com.kosgei.posts.databinding.ActivityMainBinding
import com.kosgei.posts.ui.adapters.PostAdapter
import com.kosgei.posts.ui.viewModels.PostViewModel
import com.kosgei.posts.utils.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var recyclerView: RecyclerView

    private lateinit var postAdapter: PostAdapter



    private val moviesViewModel: PostViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        recyclerView = binding.postsRecyclerView

        //set up recycler view
        setUpRecyclerView()

        //get posts
        getPost()

        setRetryBtn()
    }

    private fun setUpRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        postAdapter = PostAdapter(arrayListOf())
        recyclerView.adapter = postAdapter
    }

    private fun submitPosts(posts:List<Post>){
        postAdapter.setPosts(posts)
    }

    private fun setRetryBtn(){
        binding.retryBtn.setOnClickListener {
          moviesViewModel.fetchPosts()
    }}

    private fun getPost() {
        moviesViewModel.postsResponse.observe(this, {
            when (it.status) {
                Status.LOADING -> {

                    binding.errorLayout.isVisible =false
                    if (it.data != null) {
                        binding.postsRecyclerView.isVisible = true
                        //show minimal loading
                        submitPosts(it.data)

                        Snackbar.make(binding.root, it.message ?: "Refreshing...", Snackbar.LENGTH_SHORT).show()


                    } else {
                       // binding.shimmerFrameLayout.isVisible =true
                        //show shimmer loading
                        binding.postsRecyclerView.isVisible = false
                        binding.shimmerFrameLayout.isVisible =true
                    }
                }
                Status.SUCCESS -> {
                    binding.shimmerFrameLayout.isVisible =false
                    binding.errorLayout.isVisible =false
                    it.data?.let { posts ->
                        //show recycler view
                        binding.postsRecyclerView.isVisible = true
                        submitPosts(posts)
                    }
                }
                Status.ERROR -> {
                    binding.shimmerFrameLayout.isVisible =false
                    if (it.data != null) {
                        //show minimal error
                        val snack = Snackbar.make(binding.root, it.message ?: "Something went wrong", Snackbar.LENGTH_INDEFINITE)
                        snack.setAction("Retry") {
                            moviesViewModel.fetchPosts()
                        }
                        snack.show()

                        binding.postsRecyclerView.isVisible = true
                        submitPosts(it.data)
                    } else {
                        //show full page error
                        binding.postsRecyclerView.isVisible = false
                        binding.errorLayout.isVisible =true

                        binding.errorTxt.text = it.message ?: "Something went wrong"




                    }

                }
            }
        }
        )
    }
}