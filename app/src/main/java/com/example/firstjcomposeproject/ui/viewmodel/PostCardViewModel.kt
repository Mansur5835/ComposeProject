package com.example.firstjcomposeproject.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firstjcomposeproject.data.mapper.NewsFeedMapper
import com.example.firstjcomposeproject.data.nerwork.ApiFactory
import com.example.firstjcomposeproject.data.repository.NewsFeedRepository
import com.example.firstjcomposeproject.domein.FeedPost
import com.example.firstjcomposeproject.domein.StatisticItem
import com.example.firstjcomposeproject.domein.StatisticType
import com.vk.id.VKID
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PostCardViewModel : ViewModel() {

    private val repository = NewsFeedRepository()


    private val _uiState = MutableStateFlow<PostCardState>(PostCardState.Initial)
    val uiState = _uiState.asStateFlow()


    private val _event = MutableSharedFlow<PostCardEvent>()
    val event = _event.asSharedFlow()


    init {
        loadPost()
    }


    fun showComments(post: FeedPost) {
        viewModelScope.launch {
            _event.emit(PostCardEvent.Post(post))
        }
    }

    private fun loadPost() {
        val token = VKID.instance.accessToken?.token

        if (token == null) {
            return
        }

        viewModelScope.launch {
            _uiState.value = PostCardState.Loading
            delay(1000)
            val feedPosts = repository.loadRecommendations()
            _uiState.value = PostCardState.Loaded(feedPosts)
        }

    }





    fun delete(post: FeedPost) {
        val modifiedList = (_uiState.value as PostCardState.Loaded).posts.toMutableList()
        println("old post $modifiedList")
        modifiedList.removeIf { it.id == post.id }
        println("old post $modifiedList")
        _uiState.value = PostCardState.Loaded(modifiedList)
    }


    fun changeLikeStatus(post: FeedPost) {
        viewModelScope.launch {
            repository.changeLikeStatus(post)
            val items = repository.feedPosts
            println("asdfasdfsdf-> ${items.first().isFavorite}")
            _uiState.value = PostCardState.Loaded(items.toList())
        }
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


