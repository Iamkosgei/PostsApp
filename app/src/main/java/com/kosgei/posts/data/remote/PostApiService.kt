package com.kosgei.posts.data.remote


import com.kosgei.posts.data.models.Posts
import retrofit2.Response
import retrofit2.http.GET

interface PostApiService {
    @GET("posts")
    suspend fun getPosts(): Response<Posts>
}