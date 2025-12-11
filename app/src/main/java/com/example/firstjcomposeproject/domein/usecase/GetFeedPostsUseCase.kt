package com.example.firstjcomposeproject.domein.usecase

import com.example.firstjcomposeproject.domein.entity.FeedPost
import com.example.firstjcomposeproject.domein.repository.NewsFeedRepository
import javax.inject.Inject

class GetFeedPostsUseCase @Inject constructor(private val repository: NewsFeedRepository) {
    fun invoke(): List<FeedPost> {
        return repository.getFeedPosts()
    }
}