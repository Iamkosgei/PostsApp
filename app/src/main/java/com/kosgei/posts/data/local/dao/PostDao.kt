package com.kosgei.posts.data.local.dao


import androidx.lifecycle.LiveData
import androidx.room.*
import com.kosgei.posts.data.models.Post


@Dao
interface PostDao {
    @Query("SELECT * FROM post")
    suspend fun getAllPosts():List<Post>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPosts(posts: List<Post>)
    
}