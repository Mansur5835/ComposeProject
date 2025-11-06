package com.example.firstjcomposeproject.data.nerwork

import com.example.firstjcomposeproject.data.model.LikesCountResponseDto
import com.example.firstjcomposeproject.data.model.NewsFeedResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("newsfeed.get?v=5.199")
    suspend fun loadRecommendations(
        @Query("access_token") token: String,
    ): NewsFeedResponseDto

    @GET("newsfeed.get?v=5.199")
    suspend fun loadRecommendations(
        @Query("access_token") token: String,
        @Query("start_from") startFrom: String,
    ): NewsFeedResponseDto


    @GET("likes.add?v=5.199&type=post")
    suspend fun addLike(
        @Query("access_token") token: String,
        @Query("item_id") itemId: Long,
        @Query("owner_id") ownerId: Long,
    ): LikesCountResponseDto

    @GET("likes.delete?v=5.199&type=post")
    suspend fun deleteLike(
        @Query("access_token") token: String,
        @Query("item_id") itemId: Long,
        @Query("owner_id") ownerId: Long,
    ): LikesCountResponseDto
}