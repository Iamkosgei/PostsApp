package com.kosgei.posts.di



import com.kosgei.posts.data.repositories.PostRepository
import com.kosgei.posts.data.repositories.PostRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
abstract class PostRepositoryModule {
    @Binds
    abstract fun bindRepository(impl: PostRepositoryImpl): PostRepository
}