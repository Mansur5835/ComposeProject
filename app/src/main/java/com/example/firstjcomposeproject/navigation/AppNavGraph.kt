package com.example.firstjcomposeproject.navigation

import android.annotation.SuppressLint
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.firstjcomposeproject.PostCardViewModel
import com.example.firstjcomposeproject.ui.screens.CommentsScreen
import com.example.firstjcomposeproject.ui.screens.FavouriteScreen
import com.example.firstjcomposeproject.ui.screens.HomeScreen
import com.example.firstjcomposeproject.ui.screens.ProfileScreen

@SuppressLint("UnrememberedGetBackStackEntry")
@Composable
fun AppNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Screen.HomeScreenGraph.route
    ) {
        homeScreenNavGraph(
            navController
        )

        composable(Screen.Favourite.route) {
            FavouriteScreen()
        }
        composable(Screen.Profile.route) {
            ProfileScreen()
        }


    }
}

