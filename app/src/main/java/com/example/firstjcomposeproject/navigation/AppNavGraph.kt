package com.example.firstjcomposeproject.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.firstjcomposeproject.ui.viewmodel.AuthState
import com.example.firstjcomposeproject.ui.viewmodel.MainViewModel
import com.example.firstjcomposeproject.ui.screens.SplashScreen
import com.example.firstjcomposeproject.ui.viewmodel.ViewModelFactory

@Composable
fun AppNavGraph(
    viewModelFactory: ViewModelFactory,
    viewModel: MainViewModel = viewModel(factory = viewModelFactory)
) {
    val state by viewModel.authState.collectAsState()
    when (state) {
        AuthState.Authorized -> MainNavGraph(
            viewModelFactory = viewModelFactory,
        )
        AuthState.Initial -> SplashScreen()
        AuthState.NotAuthorized -> AuthNavGraph{
            viewModel.performAuthResult(it)
        }
    }

}

