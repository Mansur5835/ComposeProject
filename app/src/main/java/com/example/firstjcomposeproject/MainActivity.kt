package com.example.firstjcomposeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.firstjcomposeproject.navigation.AppNavGraph
import com.example.firstjcomposeproject.ui.screens.AnimationSwitchScreen
import com.example.firstjcomposeproject.ui.screens.AnimationTestScreen
import com.example.firstjcomposeproject.ui.screens.CanvasTestScreen
import com.example.firstjcomposeproject.ui.screens.PinnedScrollItemScreen
import com.example.firstjcomposeproject.ui.theme.FirstJComposeProjectTheme


class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val component = getApplicationComponent()
            FirstJComposeProjectTheme {
                Surface(
                    modifier = Modifier.Companion
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background)
                ) {
                    CanvasTestScreen()
//                    AnimationSwitchScreen()
//                    PinnedScrollItemScreen()
//                    AnimationTestScreen()
//                    AppNavGraph(
//                        component.getViewModelFactory()
//                    )
                }
            }
        }
    }
}