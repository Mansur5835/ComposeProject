package com.example.firstjcomposeproject.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.firstjcomposeproject.ui.screens.LoginScreen
import com.vk.api.sdk.auth.VKAuthenticationResult
import com.vk.id.AccessToken


@Composable
fun AuthNavGraph(
    navHostController: NavHostController = rememberNavController(),
    onLoginSuccess: (AccessToken) -> Unit
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.LoginScreen.route
    ) {
        composable(Screen.LoginScreen.route) {
            LoginScreen(onLoginSuccess)
        }
    }
}