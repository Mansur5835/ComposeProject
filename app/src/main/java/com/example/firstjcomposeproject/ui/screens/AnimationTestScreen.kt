package com.example.firstjcomposeproject.ui.screens

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.EaseInCirc
import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.animateValue
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun AnimationTestScreen() {
    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(8.dp)
                .verticalScroll(
                    state = rememberScrollState(),
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var isIncreased by remember { mutableStateOf(true) }

            val size by animateDpAsState(
                targetValue = if (isIncreased) 200.dp else 100.dp,
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioHighBouncy,
                    stiffness = Spring.StiffnessLow,

                    )
            )

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    isIncreased = !isIncreased
                }
            ) {
                Text("Animate size")
            }
            AnimatedContent(
                "Size spring",
                size = size
            )

            var isRectangle by remember { mutableStateOf(true) }

            val radius by animateIntAsState(
                targetValue = if (isRectangle) 4 else 50,

                animationSpec = tween(
                    durationMillis = 400,
                    easing = FastOutSlowInEasing
                )
            )


            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    isRectangle = !isRectangle
                }
            ) {
                Text("Animate shape")
            }
            AnimatedContent(
                "Shape tween",
                radiusPercent = radius
            )


            val infinityTransition = rememberInfiniteTransition()


            var isBordered by remember { mutableStateOf(false) }


            val border by infinityTransition.animateFloat(
                initialValue = 10f,
                targetValue = if (isBordered) 10f else 0f,
                animationSpec = infiniteRepeatable(
                    animation = tween(
                        durationMillis = 1000,

                        ),
                    repeatMode = RepeatMode.Reverse
                )
            )



            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    isBordered = !isBordered
                }
            ) {
                Text("Animate border")
            }
            AnimatedContent(
                "Border infinity animation",
                borderWidth = border.dp
            )


            var isColored by remember { mutableStateOf(true) }

            val color by animateColorAsState(targetValue = if (isColored) Color.Blue else Color.Red)


            val infiniteTransitionColorBoxRotate = rememberInfiniteTransition()

            val degree by infiniteTransitionColorBoxRotate.animateFloat(
                initialValue = 0f,
                targetValue = 360f,
                animationSpec = infiniteRepeatable(
                    animation = tween(
                        durationMillis = 700,
                        easing = LinearEasing
                    ),
                    repeatMode = RepeatMode.Restart
                )
            )



            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    isColored = !isColored
                }
            ) {
                Text("Animate color")
            }
            AnimatedContent(
                "Color",
                color = color,
                degree = degree
            )

            var isTransparent by remember { mutableStateOf(false) }

            val alpha by animateFloatAsState(targetValue = if (isTransparent) 0f else 1f)



            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    isTransparent = !isTransparent
                }
            ) {
                Text("Animate visibility")
            }
            AnimatedContent(
                "Visibility",
                alpha = alpha

            )
        }


    }
}


@Composable
private fun AnimatedContent(
    text: String,
    size: Dp = 200.dp,
    radiusPercent: Int = 4,
    borderWidth: Dp = 0.dp,
    color: Color = Color.Blue,
    alpha: Float = 1f,
    degree: Float = 0f

) {
    Box(
        modifier = Modifier
            .rotate(degree)
            .alpha(alpha)
            .clip(
                RoundedCornerShape(radiusPercent)
            )
            .background(color)
            .then(
                if (borderWidth > 0.dp)
                    Modifier.border(borderWidth, Color.White)
                else Modifier
            )
            .size(size),

        contentAlignment = Alignment.Center
    ) {
        Text(
            text,
            color = Color.White
        )
    }
}