package com.example.firstjcomposeproject.ui.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.VectorProperty
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEach
import androidx.compose.ui.util.fastForEachIndexed

@Composable
fun CanvasTestScreen() {

    var points by rememberSaveable { mutableStateOf<List<Offset>>(listOf()) }

    Scaffold {
        Canvas(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .pointerInput(Unit) {
//                    detectTapGestures {
//                        points = points + it
//                    }

                    detectDragGestures { change, of ->
                        points = points + of
                    }


                }
        ) {
            val path = Path()


            points.fastForEachIndexed { index, value ->
                if (index == 0) {
                    path.moveTo(value.x, value.y)
                } else {
                    path.lineTo(value.x, value.y)
                }


            }
            drawPath(
                path = path,
                color = Color.White,
                style = Stroke(width = 2.dp.toPx())
            )


        }
    }
}

private fun DrawScope.drawPaths() {
    drawPath(
        path = Path().apply {
            moveTo(center.x, center.y - 100.dp.toPx())
            lineTo(center.x + 50.dp.toPx(), center.y)
            lineTo(center.x + 150.dp.toPx(), center.y + 10.dp.toPx())
            lineTo(center.x + 80.dp.toPx(), center.y + 100.dp.toPx())
            lineTo(center.x + 110.dp.toPx(), center.y + 200.dp.toPx())
            lineTo(center.x, center.y + 155.dp.toPx())
            lineTo(center.x - 110.dp.toPx(), center.y + 200.dp.toPx())
            lineTo(center.x - 80.dp.toPx(), center.y + 100.dp.toPx())
            lineTo(center.x - 150.dp.toPx(), center.y + 10.dp.toPx())
            lineTo(center.x - 50.dp.toPx(), center.y)
            lineTo(center.x, center.y - 100.dp.toPx())

        },
        color = Color.White,
        style = Fill //Stroke(width = 2.dp.toPx())
    )
}

private fun DrawScope.drawLines() {
    drawLine(
        color = Color.Red,
        start = Offset(size.width, 0f),
        end = Offset(0f, size.height),
        strokeWidth = 5.dp.toPx()
    )


    drawLine(
        color = Color.Red,
        start = Offset(0f, 0f),
        end = Offset(size.width, size.height),
        strokeWidth = 5.dp.toPx()
    )

    drawLine(
        color = Color.Red,
        start = Offset(0f, size.height / 2),
        end = Offset(size.width, size.height / 2),
        strokeWidth = 5.dp.toPx()
    )

    drawLine(
        color = Color.Red,
        start = Offset(size.width / 2, 0f),
        end = Offset(size.width / 2, size.height),
        strokeWidth = 5.dp.toPx()
    )

    drawLine(
        color = Color.Red,
        start = Offset(0f, size.height / 4),
        end = Offset(size.width, size.height * 0.75f),
        strokeWidth = 5.dp.toPx()
    )

    drawLine(
        color = Color.Red,
        start = Offset(0f, size.height * 0.75f),
        end = Offset(size.width, size.height / 4),
        strokeWidth = 5.dp.toPx()
    )

    drawCircle(
        color = Color.Red,
        radius = 20.dp.toPx(),
    )
}


