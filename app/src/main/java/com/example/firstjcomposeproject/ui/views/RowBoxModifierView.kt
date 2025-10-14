package com.example.firstjcomposeproject.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun RowBoxModifierView() {
    Column {
        for (indexOfC in 1 until 11) {
            Row(
                modifier = Modifier.weight(1F)
            ) {
                for (indexOfR in 1 until 11) {
                    val number = (indexOfC - 1) * 10 + indexOfR
                    val color = if ((indexOfC + indexOfR) % 2 == 0) Color.Red else Color.Green

                    Box(
                        modifier = Modifier
                            .weight(1F)
                            .fillMaxHeight()
                            .border(
                                width = 1.dp,
                                color = Color.Black
                            )
                            .background(color),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            "$number",
                        )
                    }

                }
            }
        }

    }
}


@Preview
@Composable
fun RowBoxModifierViewPreview() {
    Surface {
        RowBoxModifierView()
    }
}