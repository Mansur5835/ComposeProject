package com.example.firstjcomposeproject.ui.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ColumnView() {
    Scaffold(
        content = { padding ->
            Surface(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize(),
                color = Color(0xFFD40B0B),

                ) {
                Column {
                    repeat(10) {
                        Text(
                            "$it: Mansur Gulomov",
                            color = Color.White,
                        )

                    }


                }
            }
        }
    )
}


@Preview(
    showBackground = true,
    device = Devices.NEXUS_5
)
@Composable
fun UserInfoPreview() {
    ColumnView()
}

