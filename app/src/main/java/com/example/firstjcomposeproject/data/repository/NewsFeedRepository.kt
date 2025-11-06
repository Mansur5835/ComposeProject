package com.example.firstjcomposeproject.data.repository

import com.example.firstjcomposeproject.data.mapper.NewsFeedMapper
import com.example.firstjcomposeproject.data.nerwork.ApiFactory
import com.example.firstjcomposeproject.domein.FeedPost
import com.example.firstjcomposeproject.domein.PostComment
import com.example.firstjcomposeproject.domein.StatisticItem
import com.example.firstjcomposeproject.domein.StatisticType
import com.example.firstjcomposeproject.ui.viewmodel.CommentsState
import com.example.firstjcomposeproject.ui.viewmodel.getItemByType

class NewsFeedRepository {
    private val apiService = ApiFactory.apiService
    private val mapper = NewsFeedMapper()


    private val _feedPosts = mutableListOf<FeedPost>()
    val feedPosts: List<FeedPost>
        get() = _feedPosts


    suspend fun loadRecommendations(): List<FeedPost> {
        val posts = mapper.mapResponseToPosts(null)
        _feedPosts.addAll(posts)
        return posts
    }

    suspend fun changeLikeStatus(feedPost: FeedPost) {

        val oldCountLikes = feedPost.statisticItems.getItemByType(StatisticType.LIKES).count
        val newCountLikes = if (feedPost.isFavorite) oldCountLikes - 1 else oldCountLikes + 1


        val newStatistics = feedPost.statisticItems.toMutableList().apply {
            removeIf { it.type == StatisticType.LIKES }
            add(StatisticItem(StatisticType.LIKES, newCountLikes))
        }

        val newPost = feedPost.copy(
            statisticItems = newStatistics,
            isFavorite = !feedPost.isFavorite
        )
        val postIndex = _feedPosts.indexOf(feedPost)

        println("postIndex ${_feedPosts.size}")

        _feedPosts[postIndex] = newPost
    }


    suspend fun getComments(feedPost: FeedPost): List<PostComment> {
        return mapper.mapResponseToComments()


    }


}