package com.example.firstjcomposeproject.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun PinnedScrollItemScreen() {
    Scaffold {
        LazyColumn(
            modifier = Modifier.padding(it),
            contentPadding = PaddingValues(
                horizontal = 10.dp
            )
        ) {

            items(10) {
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {},

                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Red
                    )
                ) {
                    Text("Item $it")
                }
            }

            stickyHeader {
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {},

                    ) {
                    Text("This is pinned item ")
                }
            }

            items(20) {
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {},

                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Red
                    )
                ) {
                    Text("Item $it")
                }
            }

            stickyHeader {
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {},

                    ) {
                    Text("This is pinned item ")
                }

            }
            items(50) {
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {},

                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Red
                    )
                ) {
                    Text("Item $it")
                }

            }
        }
    }

}