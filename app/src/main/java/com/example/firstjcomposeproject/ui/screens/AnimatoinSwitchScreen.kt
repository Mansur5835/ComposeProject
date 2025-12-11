package com.example.firstjcomposeproject.ui.screens

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.Crossfade
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOut
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.animation.with
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp

@Composable
fun AnimationSwitchScreen() {


    Scaffold {
        Column(
            modifier = Modifier
                .padding(it)
                .padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)


        ) {

            var isFirstScreenLaunched by remember { mutableStateOf<Boolean>(true) }

            Button(
                onClick = {
                    isFirstScreenLaunched = !isFirstScreenLaunched
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Switch Screen")
            }




            AnimatedContent(
                targetState = isFirstScreenLaunched,
                transitionSpec = {

                    if (targetState) {
                        slideIn(
                            tween(2000)
                        ) {
                            IntOffset(0, -it.height)
                        } togetherWith fadeOut(
                            tween(2000)
                        )
                    } else {
                        slideIn(
                            tween(2000)
                        ) {
                            IntOffset(0, it.height)
                        } togetherWith fadeOut(
                            tween(2000)
                        )
                    }


                }
            ) {
                if (it) {
                    Screen1()
                } else {
                    Screen2()
                }
            }


        }
    }
}


@Composable
private fun Screen1() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {

    }
}

@Composable
private fun Screen2() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue)
    ) {

    }
}