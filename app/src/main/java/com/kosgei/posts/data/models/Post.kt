package com.kosgei.posts.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Post(
    @PrimaryKey
    val id: Int,
    val body: String,
    val title: String,
    val userId: Int
)