package com.example.firstjcomposeproject.navigation

import android.net.Uri
import com.example.firstjcomposeproject.domein.FeedPost
import com.google.gson.Gson

sealed class Screen(
    val route: String,
) {
    object LoginScreen : Screen("login")
    object HomeScreen : Screen("home")
    object Favourite : Screen("favourite")
    object Profile : Screen("profile")
    object Comments : Screen("comments/{feedPost}") {
        fun createRoute(feedPost: FeedPost): String {
            val feedPostJson = Gson().toJson(feedPost)
            return "comments/${feedPostJson.encodeToUrl()}"
        }
    }

    object HomeScreenGraph : Screen("home_graph")
}


private fun String.encodeToUrl(): String {
    return Uri.encode(this);
}