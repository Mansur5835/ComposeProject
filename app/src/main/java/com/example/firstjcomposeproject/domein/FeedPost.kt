package com.example.firstjcomposeproject.domein

import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavType
import com.google.gson.Gson
import kotlinx.parcelize.Parcelize


@Parcelize
data class FeedPost(
    val id: Int = 0,
    val communityName: String = "/dev/null",
    val publicationDate: String = "14:00",
    val avatar: String = "https://images.unsplash.com/photo-1578589385251-045f05a6faa5?ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&q=80&w=1760",
    val contentText: String = "Compose has several useful graphics Modifiers which aid in drawing custom content. These modifiers are useful because they can be applied to any composable.",
    val contentImage: String = "https://plus.unsplash.com/premium_photo-1698405202949-1313de4a437d?ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&q=80&w=1640",
    val statisticItems: List<StatisticItem> = listOf(
        StatisticItem(
            StatisticType.VIEW,
            916,
        ),
        StatisticItem(
            StatisticType.SHARES,
            7,
        ),
        StatisticItem(
            StatisticType.COMMENTS,
            8,
        ),
        StatisticItem(
            StatisticType.LIKES,
            23,
        ),
    )
) : Parcelable {
    companion object {
        val NavigationType: NavType<FeedPost> = object : NavType<FeedPost>(false) {
            override fun put(
                bundle: Bundle,
                key: String,
                value: FeedPost
            ) {
                bundle.putParcelable(key, value)
            }

            override fun get(
                bundle: Bundle,
                key: String
            ): FeedPost? {
                return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    bundle.getParcelable(key, FeedPost::class.java)
                } else {
                    @Suppress("DEPRECATION")
                    bundle.getParcelable(key)
                }
            }

            override fun parseValue(value: String): FeedPost {
                return Gson().fromJson(value, FeedPost::class.java)
            }
        }
    }
}