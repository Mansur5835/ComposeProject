package com.example.firstjcomposeproject.data.mapper

import android.annotation.SuppressLint
import com.example.firstjcomposeproject.data.model.NewsFeedResponseDto
import com.example.firstjcomposeproject.domein.FeedPost
import com.example.firstjcomposeproject.domein.PostComment
import com.example.firstjcomposeproject.domein.StatisticItem
import com.example.firstjcomposeproject.domein.StatisticType
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import kotlin.Int
import kotlin.random.Random

class NewsFeedMapper {
    fun mapResponseToPosts(responseDto: NewsFeedResponseDto?): List<FeedPost> {
        val result = mutableListOf<FeedPost>()

//        val posts = responseDto.newsFeedContentDto.posts
//        val groups = responseDto.newsFeedContentDto.groups


        for (id in 1 until 100) {

            val feedPost = FeedPost(
                id = id.toString(),
                communityId = id.toString(),
                communityName = "CommunityName",
                publicationDate = mapDateFormat(Date()),
                contentText = "To use VK SDK primarily you need to create a new VK application here by choosing the Standalone application type. Choose a title and confirm the action via SMS and you will be redirected to the application settings page. You will require your Application ID (referenced as API_ID in the documentation). Fill in the \"Batch name for Android\", \"Main Activity for Android\" and \"Certificate fingerprint for Android\".\n" +
                        "\n" +
                        "Certificate Fingerprint Receiving\n" +
                        "To receive your certificate's fingerprint you can use one of the following methods.\n",
                communityImageUrl = "https://arfacial.com/wp-content/uploads/2022/09/primer-plano-cara-hermosa-mujer-sensual_176420-17676.jpg",
                contentImageUrl = "https://thumbs.dreamstime.com/b/magic-book-open-nature-31575720.jpg",
                statisticItems = listOf(
                    StatisticItem(
                        type = StatisticType.LIKES,
                        Random.nextInt(800000),
                    ),
                    StatisticItem(
                        type = StatisticType.COMMENTS,
                        Random.nextInt(1000),
                    ),
                    StatisticItem(
                        type = StatisticType.SHARES,
                        Random.nextInt(500),
                    ),
                    StatisticItem(
                        type = StatisticType.VIEW,
                        Random.nextInt(10000000),
                    ),
                ),
                isFavorite = Random.nextBoolean()
            )

            result.add(feedPost)
        }


        return result

    }


    fun mapResponseToComments(): List<PostComment> {
        val list = mutableListOf<PostComment>()
        for (id in 1 until 45) {
            list.add(
                PostComment(
                    id = id,
                    authorName = "Author",
                    avatar = "https://imgv3.fotor.com/images/slider-image/A-clear-image-of-a-woman-wearing-red-sharpened-by-Fotors-image-sharpener.jpg",
                    commentText = "Long comment text",
                    publicDate = "14:35"
                )
            )

        }
        return list

    }


    private fun mapDateFormat(date: Date): String {
        return SimpleDateFormat("dd MMMM yyyy, hh:mm", Locale.getDefault()).format(date)

    }
}