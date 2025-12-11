package com.example.firstjcomposeproject.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firstjcomposeproject.data.repository.NewsFeedRepositoryImpl
import com.example.firstjcomposeproject.domein.repository.NewsFeedRepository
import com.example.firstjcomposeproject.domein.entity.FeedPost
import com.example.firstjcomposeproject.domein.entity.PostComment
import com.example.firstjcomposeproject.domein.usecase.GetCommentsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class CommentsViewModel @Inject constructor(
    private val post: FeedPost,
    private val getCommentsUseCase: GetCommentsUseCase
) : ViewModel() {

    private val _commentsState = MutableStateFlow<CommentsState>(CommentsState.Initial)
    val commentsState = _commentsState.asStateFlow()


    init {
        loadComments(post)
    }

    private fun loadComments(post: FeedPost) {

        viewModelScope.launch {
            val comments = getCommentsUseCase.invoke(post)
            _commentsState.value = CommentsState.Comments(comments)
        }

    }

}

sealed class CommentsState {
    object Initial : CommentsState()
    data class Comments(val comments: List<PostComment>) : CommentsState()
}