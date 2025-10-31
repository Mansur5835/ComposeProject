package com.example.firstjcomposeproject.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.firstjcomposeproject.domein.FeedPost
import com.example.firstjcomposeproject.ui.screens.CommentsScreen
import com.example.firstjcomposeproject.ui.screens.HomeScreen
import com.google.gson.Gson


fun NavGraphBuilder.homeScreenNavGraph(
    navController: NavController
) {
    navigation(
        Screen.HomeScreen.route,
        route = Screen.HomeScreenGraph.route
    ) {

        composable(Screen.HomeScreen.route) {
            HomeScreen(
                navigateComments = {
                    navController.navigate(Screen.Comments.createRoute(it))
                }
            )
        }

        composable(
            Screen.Comments.route,
            arguments = listOf(navArgument("feedPost") { type = FeedPost.NavigationType })
        ) {
            val feedPost =
                it.arguments?.getParcelable<FeedPost>("feedPost")
                    ?: throw RuntimeException("feedPost args is null")


            CommentsScreen(
                feedPost = feedPost,
                popBack = {
                    navController.popBackStack()
                }
            )
        }

    }
}