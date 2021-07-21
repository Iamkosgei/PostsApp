package com.kosgei.posts.data.repositories

import androidx.lifecycle.LiveData
import com.kosgei.posts.data.local.dao.PostDao
import com.kosgei.posts.data.models.Post
import com.kosgei.posts.data.remote.PostApiService
import com.kosgei.posts.utils.ResultWrapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import java.io.IOException
import java.net.SocketException
import java.net.UnknownHostException
import javax.inject.Inject


interface PostRepository {
    suspend fun fetchPosts(): Flow<ResultWrapper<List<Post>>>
    suspend fun getPosts(): List<Post>
    suspend fun savePosts(posts: List<Post>)
}


class PostRepositoryImpl @Inject constructor(
    private val postApiService: PostApiService,
    private val postDao: PostDao
) : PostRepository {
    override suspend fun fetchPosts(): Flow<ResultWrapper<List<Post>>> {
        return flow {
            //get cached posts
            val cachedPost = getPosts()
            if (cachedPost.isNotEmpty()) {
                //show minimal loading
                emit(ResultWrapper.loading(data = cachedPost))
            } else {
                //show full loading
                emit(ResultWrapper.loading(data = null))
            }
            try {
                val postResponse = postApiService.getPosts()


                if (postResponse.isSuccessful) {
                    postResponse.body().let {
                        val postLists = mutableListOf<Post>()
                        it?.forEach { post ->
                            postLists.add(post)
                        }
                        savePosts(postLists)
                        emit(ResultWrapper.success(data = postLists))
                    }
                } else {
                    emit(
                        ResultWrapper.error(
                            data = if (cachedPost.isNotEmpty()) cachedPost else null,
                            message = postResponse.message()
                        )
                    )

                }

            } catch (e: Exception) {

                if (e is IOException) {
                    emit(
                        ResultWrapper.error(
                            data = if (cachedPost.isNotEmpty()) cachedPost else null,
                            message = "Please check your internet connection and try again."
                        )
                    )
                } else {
                    emit(
                        ResultWrapper.error(
                            data = if (cachedPost.isNotEmpty()) cachedPost else null,
                            message = e.message ?: e.toString()
                        )
                    )
                }
            }
        }
    }

    override suspend fun getPosts(): List<Post> {
        return postDao.getAllPosts()
    }

    override suspend fun savePosts(posts: List<Post>) {
        return postDao.insertPosts(posts)
    }


}