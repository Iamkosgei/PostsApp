package com.kosgei.posts.data.local.db


import androidx.room.Database
import androidx.room.RoomDatabase
import com.kosgei.posts.data.local.dao.PostDao
import com.kosgei.posts.data.models.Post
import com.kosgei.posts.utils.ROOM_VERSION

@Database(entities = [Post::class], version = ROOM_VERSION,exportSchema = false)
abstract class PostDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao
}