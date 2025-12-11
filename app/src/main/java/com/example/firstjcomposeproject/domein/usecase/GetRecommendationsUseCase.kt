package com.example.firstjcomposeproject.domein.usecase

import com.example.firstjcomposeproject.domein.entity.FeedPost
import com.example.firstjcomposeproject.domein.repository.NewsFeedRepository
import javax.inject.Inject

class GetRecommendationsUseCase @Inject constructor(private val repository: NewsFeedRepository) {
    suspend fun invoke(): List<FeedPost> {
        return repository.loadRecommendations()
    }
}