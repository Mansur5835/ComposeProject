package com.example.firstjcomposeproject.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.firstjcomposeproject.MainViewModel
import com.example.firstjcomposeproject.PostCardViewModel
import com.example.firstjcomposeproject.domein.InstagramModel
import com.example.firstjcomposeproject.ui.theme.FirstJComposeProjectTheme
import com.example.firstjcomposeproject.ui.views.InstagramProfileCard
import com.vk.api.sdk.VK

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        VK.login(this, {})
        setContent {
            FirstJComposeProjectTheme {
//                ActivityResultExampleScreen()
                MainScreen()
//
//                Scaffold(
//                    content = { padding ->
//                        Surface(
//                            modifier = Modifier
//                                .padding(padding)
//                                .background(MaterialTheme.colorScheme.background)
//                                .padding(8.dp),
//                        ) {
//                            val models = viewModel.models.observeAsState(listOf())
//                            Items(models.value, viewModel)
//                        }
//                    },
//                )

            }


        }
    }
}


@Composable
private fun Items(models: List<InstagramModel>, viewModel: MainViewModel) {
    LazyColumn {
        items(
            models,
            key = {
                it.id
            },
        ) { model ->
            val dismissState =
                rememberSwipeToDismissBoxState(
                    confirmValueChange = {
                        if (it == SwipeToDismissBoxValue.EndToStart) {
                            viewModel.deleteItem(model)
                        }
                        it != SwipeToDismissBoxValue.StartToEnd
                    },
                )
            SwipeToDismissBox(
                modifier = Modifier.animateItem(),
                state = dismissState,
                enableDismissFromStartToEnd = false,

                backgroundContent = {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                            .background(Color.Red),
                        contentAlignment = Alignment.CenterEnd
                    ) {
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.padding(end = 16.dp)
                        )
                    }

                }

            ) {
                InstagramProfileCard(model) {
                    viewModel.changeFollowingStatus(model)
                }
            }
        }
    }
}
