package com.example.firstjcomposeproject.ui.views

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.firstjcomposeproject.navigation.Screen

sealed class NavigationItem(
    val screen: Screen,
    val title: String,
    val iconSelected: ImageVector,
    val icon: ImageVector,
) {


    data object Home : NavigationItem(
        screen = Screen.HomeScreenGraph,
        title = "Home",
        iconSelected = Icons.Filled.Home,
        icon = Icons.Outlined.Home,
    )

    data object Favorite : NavigationItem(
        screen = Screen.Favourite,
        title = "Favorite",
        iconSelected = Icons.Filled.Favorite,
        icon = Icons.Outlined.FavoriteBorder,
    )

    data object Profile : NavigationItem(
        screen = Screen.Profile,
        title = "Profile",
        iconSelected = Icons.Filled.Person,
        icon = Icons.Outlined.Person,
    )

}