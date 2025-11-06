package com.example.firstjcomposeproject.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firstjcomposeproject.data.repository.NewsFeedRepository
import com.example.firstjcomposeproject.domein.FeedPost
import com.example.firstjcomposeproject.domein.PostComment
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CommentsViewModel(post: FeedPost) : ViewModel() {
    private val repository = NewsFeedRepository()

    private val _commentsState = MutableStateFlow<CommentsState>(CommentsState.Initial)
    val commentsState = _commentsState.asStateFlow()


    init {
        loadComments(post)
    }

    private fun loadComments(post: FeedPost) {

        viewModelScope.launch {
            val comments = repository.getComments(post)
            _commentsState.value = CommentsState.Comments(comments)
        }

    }

}

sealed class CommentsState {
    object Initial : CommentsState()
    data class Comments(val comments: List<PostComment>) : CommentsState()
}