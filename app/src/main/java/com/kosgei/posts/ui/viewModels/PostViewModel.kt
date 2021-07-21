package com.kosgei.posts.ui.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kosgei.posts.data.models.Post
import com.kosgei.posts.data.repositories.PostRepository
import com.kosgei.posts.utils.ResultWrapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PostViewModel @Inject constructor(private val postRepository: PostRepository) :
    ViewModel() {
    private var _postsResponse = MutableLiveData<ResultWrapper<List<Post>>>()
    val postsResponse get() = _postsResponse

    init {
        fetchPosts()

    }

    fun fetchPosts() {
        viewModelScope.launch {
            postRepository.fetchPosts().collect {
                _postsResponse.postValue(it)
            }
        }
    }
}