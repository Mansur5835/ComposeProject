package com.example.firstjcomposeproject.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.firstjcomposeproject.ui.screens.FavouriteScreen
import com.example.firstjcomposeproject.ui.screens.LoginScreen
import com.example.firstjcomposeproject.ui.screens.ProfileScreen
import com.example.firstjcomposeproject.ui.views.NavigationItem


@Composable
fun MainNavGraph(navController: NavHostController = rememberNavController()) {
    Scaffold(
        bottomBar = {
            BottomBar(
                navController
            )
        }
    ) {
        NavHost(
            modifier = Modifier.padding(it),
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


}


@Composable
private fun BottomBar(navHostController: NavHostController) {
    val items = listOf(NavigationItem.Home, NavigationItem.Favorite, NavigationItem.Profile)
    val navStackEntry by navHostController.currentBackStackEntryAsState()

    NavigationBar {
        items.mapIndexed { index, navigationItem ->
            val selected = navStackEntry?.destination?.hierarchy?.any {
                it.route == navigationItem.screen.route
            } ?: false
            NavigationBarItem(
                selected = selected,
                onClick = {
                    navHostController.navigate(navigationItem.screen.route) {
                        launchSingleTop = true
                        popUpTo(navHostController.graph.startDestinationId) {
                            saveState = true
                        }
                        restoreState = true
                    }
                },
                label = {
                    Text(
                        navigationItem.title,
                    )
                },
                icon = {
                    Icon(
                        imageVector = if (selected) navigationItem.iconSelected else navigationItem.icon,
                        contentDescription = null,
                    )
                }
            )

        }

    }
}
