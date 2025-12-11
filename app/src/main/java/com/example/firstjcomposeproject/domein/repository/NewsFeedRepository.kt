package com.example.firstjcomposeproject.domein.repository

import com.example.firstjcomposeproject.data.mapper.NewsFeedMapper
import com.example.firstjcomposeproject.data.nerwork.ApiFactory
import com.example.firstjcomposeproject.domein.entity.FeedPost
import com.example.firstjcomposeproject.domein.entity.PostComment
import com.example.firstjcomposeproject.domein.entity.StatisticItem
import com.example.firstjcomposeproject.domein.entity.StatisticType
import com.example.firstjcomposeproject.ui.viewmodel.getItemByType

interface NewsFeedRepository {

    fun getFeedPosts(): List<FeedPost>


    suspend fun loadRecommendations(): List<FeedPost>

    suspend fun changeLikeStatus(feedPost: FeedPost)


    suspend fun getComments(feedPost: FeedPost): List<PostComment>


}