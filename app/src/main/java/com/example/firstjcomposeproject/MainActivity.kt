package com.example.firstjcomposeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.firstjcomposeproject.ui.theme.FirstJComposeProjectTheme
import com.example.firstjcomposeproject.ui.views.ColumnView
import com.example.firstjcomposeproject.ui.views.InstagramProfileCard
import com.example.firstjcomposeproject.ui.views.PostCard
import com.example.firstjcomposeproject.ui.views.RowBoxModifierView
import com.example.firstjcomposeproject.ui.views.ScaffoldView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FirstJComposeProjectTheme {
                ScaffoldView()
//                Scaffold(
//                    content = { padding ->
//                        Surface(
//                            modifier = Modifier
//                                .padding(padding)
//                                .background(MaterialTheme.colorScheme.background)
//                                .padding(8.dp),
//                        ) {
//                            PostCard()
//                        }
//                    }
//                )

            }


        }
    }
}


