package com.example.firstjcomposeproject.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.firstjcomposeproject.domein.entity.FeedPost
import com.example.firstjcomposeproject.ui.screens.CommentsScreen
import com.example.firstjcomposeproject.ui.screens.HomeScreen
import com.example.firstjcomposeproject.ui.viewmodel.ViewModelFactory


fun NavGraphBuilder.homeScreenNavGraph(
    navController: NavController,
    viewModelFactory: ViewModelFactory,
) {
    navigation(
        Screen.HomeScreen.route,
        route = Screen.HomeScreenGraph.route
    ) {
        composable(Screen.HomeScreen.route) {
            HomeScreen(
                viewModelFactory,
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
                viewModelFactory,
                feedPost = feedPost,
                popBack = {
                    navController.popBackStack()
                }
            )
        }

    }
}