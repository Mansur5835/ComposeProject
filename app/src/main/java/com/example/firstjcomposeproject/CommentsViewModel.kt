package com.example.firstjcomposeproject

import androidx.lifecycle.ViewModel
import com.example.firstjcomposeproject.domein.PostComment
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CommentsViewModel(postId: Int) : ViewModel() {

    private val _commentsState = MutableStateFlow<CommentsState>(CommentsState.Initial)
    val commentsState = _commentsState.asStateFlow()


    init {
        loadComments(postId)
    }

    private fun loadComments(postId: Int) {
        val comments = mutableListOf<PostComment>().apply {
            repeat(10) {
                add(
                    PostComment(
                        it
                    )
                )
            }
        }

        _commentsState.value = CommentsState.Comments(comments)

    }

}

sealed class CommentsState {
    object Initial : CommentsState()
    data class Comments(val comments: List<PostComment>) : CommentsState()
}