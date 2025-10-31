package com.example.firstjcomposeproject

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firstjcomposeproject.domein.FeedPost
import com.example.firstjcomposeproject.domein.PostComment
import com.example.firstjcomposeproject.domein.StatisticItem
import com.example.firstjcomposeproject.domein.StatisticType
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PostCardViewModel : ViewModel() {


    private val _uiState = MutableStateFlow<PostCardState>(PostCardState.Initial)
    val uiState = _uiState.asStateFlow()


    private val _event = MutableSharedFlow<PostCardEvent>()
    val event = _event.asSharedFlow()


    private var feedPosts = mutableListOf<FeedPost>().apply {
        repeat(10) {
            add(
                FeedPost(
                    id = it
                )
            )
        }
    }

    init {
        loadPost()
    }


    fun showComments(post: FeedPost) {
        viewModelScope.launch {
            _event.emit(PostCardEvent.Post(post))
        }
    }

    private fun loadPost() {
        _uiState.value = PostCardState.Loading
        viewModelScope.launch {
            delay(1000)
            _uiState.value = PostCardState.Loaded(feedPosts)

        }
    }


    fun countUpStatistic(post: FeedPost, type: StatisticType) {
        val modifiedList = (_uiState.value as PostCardState.Loaded).posts.toMutableList()
        val modifiedStatistics = post.statisticItems.toMutableList()

        val newPost = post.copy(
            statisticItems = modifiedStatistics.apply {
                replaceAll {
                    if (it.type == type) it.copy(count = it.count + 1) else it
                }
            }
        )

        val newPosts = modifiedList.apply {
            replaceAll {
                if (post.id == it.id) newPost else it
            }
        }


        _uiState.value = PostCardState.Loaded(newPosts)


    }

    fun delete(post: FeedPost) {
        val modifiedList = (_uiState.value as PostCardState.Loaded).posts.toMutableList()
        println("old post $modifiedList")
        modifiedList.removeIf { it.id == post.id }
        println("old post $modifiedList")
        _uiState.value = PostCardState.Loaded(modifiedList)
    }

}


sealed class PostCardState {
    object Initial : PostCardState()
    object Loading : PostCardState()
    data class Loaded(val posts: List<FeedPost> = listOf()) : PostCardState()
}


sealed class PostCardEvent {
    object Initial : PostCardEvent()
    data class Post(val post: FeedPost) : PostCardEvent()
}


fun List<StatisticItem>.getItemByType(type: StatisticType): StatisticItem {
    return this.find { type == it.type } ?: throw IllegalStateException()
}


