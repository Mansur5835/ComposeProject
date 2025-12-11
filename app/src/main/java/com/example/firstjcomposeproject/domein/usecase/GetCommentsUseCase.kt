package com.example.firstjcomposeproject.domein.usecase

import com.example.firstjcomposeproject.domein.entity.FeedPost
import com.example.firstjcomposeproject.domein.entity.PostComment
import com.example.firstjcomposeproject.domein.repository.NewsFeedRepository
import javax.inject.Inject

class GetCommentsUseCase @Inject constructor(private val repository: NewsFeedRepository) {
    suspend fun invoke(feedPost: FeedPost): List<PostComment> {
        return repository.getComments(feedPost)
    }
}