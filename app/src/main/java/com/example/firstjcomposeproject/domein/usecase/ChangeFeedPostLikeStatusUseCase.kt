package com.example.firstjcomposeproject.domein.usecase

import com.example.firstjcomposeproject.domein.entity.FeedPost
import com.example.firstjcomposeproject.domein.repository.NewsFeedRepository
import javax.inject.Inject

class ChangeFeedPostLikeStatusUseCase @Inject  constructor(
    private val repository: NewsFeedRepository
) {
    suspend fun invoke(feedPost: FeedPost) {
        return repository.changeLikeStatus(feedPost)
    }
}