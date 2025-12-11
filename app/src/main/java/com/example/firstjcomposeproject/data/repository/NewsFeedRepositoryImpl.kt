package com.example.firstjcomposeproject.data.repository

import com.example.firstjcomposeproject.data.mapper.NewsFeedMapper
import com.example.firstjcomposeproject.data.nerwork.ApiFactory
import com.example.firstjcomposeproject.data.nerwork.ApiService
import com.example.firstjcomposeproject.domein.entity.FeedPost
import com.example.firstjcomposeproject.domein.entity.PostComment
import com.example.firstjcomposeproject.domein.entity.StatisticItem
import com.example.firstjcomposeproject.domein.entity.StatisticType
import com.example.firstjcomposeproject.domein.repository.NewsFeedRepository
import com.example.firstjcomposeproject.ui.viewmodel.getItemByType
import javax.inject.Inject

class NewsFeedRepositoryImpl @Inject constructor(
    private val mapper: NewsFeedMapper,
    private val apiService: ApiService,
) : NewsFeedRepository {


    private val _feedPosts = mutableListOf<FeedPost>()


    override fun getFeedPosts(): List<FeedPost> {
        return _feedPosts
    }


    override suspend fun loadRecommendations(): List<FeedPost> {
        val posts = mapper.mapResponseToPosts(null)
        _feedPosts.addAll(posts)
        return posts
    }

    override suspend fun changeLikeStatus(feedPost: FeedPost) {

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


    override suspend fun getComments(feedPost: FeedPost): List<PostComment> {
        return mapper.mapResponseToComments()


    }


}