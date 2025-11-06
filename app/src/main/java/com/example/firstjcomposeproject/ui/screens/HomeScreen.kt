package com.example.firstjcomposeproject.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.firstjcomposeproject.ui.viewmodel.PostCardEvent
import com.example.firstjcomposeproject.ui.viewmodel.PostCardState
import com.example.firstjcomposeproject.ui.viewmodel.PostCardViewModel
import com.example.firstjcomposeproject.domein.FeedPost
import com.example.firstjcomposeproject.domein.StatisticType
import com.example.firstjcomposeproject.ui.views.PostCard
import kotlinx.coroutines.launch


@Composable
fun HomeScreen(
    viewModel: PostCardViewModel = viewModel(),
    navigateComments: (FeedPost) -> Unit,
) {

    val state by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.event.collect { event ->
            when (event) {
                is PostCardEvent.Post -> {
                    navigateComments(event.post)
                }

                PostCardEvent.Initial -> {}
            }
        }
    }



    when (state) {
        is PostCardState.Loading, PostCardState.Initial -> {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                CircularProgressIndicator()
            }
        }

        is PostCardState.Loaded -> {
            val posts = (state as PostCardState.Loaded).posts

            PostCardViews(
                posts,
                onDelete = { post ->
                    viewModel.delete(post)
                },
                onClick = { post, type ->

                    println("\nasdfasdf-> ${post.id}\n${post.isFavorite}\n")
                    when (type) {
                        StatisticType.VIEW -> {
//                            viewModel.countUpStatistic(post, type)
                        }

                        StatisticType.COMMENTS -> {
                            viewModel.showComments(post)
                        }

                        StatisticType.SHARES -> {
//                            viewModel.countUpStatistic(post, type)
                        }

                        StatisticType.LIKES -> {
                            viewModel.changeLikeStatus(post)
                        }
                    }

                }
            )
        }
    }


}

@Composable
private fun PostCardViews(
    posts: List<FeedPost>,
    onClick: (FeedPost, StatisticType) -> Unit,
    onDelete: (FeedPost) -> Unit
) {

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text("Drawer title", modifier = Modifier.padding(16.dp))
                }
                HorizontalDivider()
                NavigationDrawerItem(
                    label = { Text(text = "Drawer Item") },
                    selected = false,
                    onClick = { }
                )
            }
        }
    ) {
        Scaffold(
            topBar = {
                AppBar(drawerState)
            }

        ) {
            LazyColumn(
                modifier = Modifier
                    .padding(
                        top = it.calculateTopPadding(),
                        start = 8.dp,
                        end = 8.dp,
//            bottom = 8.dp,
                    ),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(posts, key = { it.id }) { post ->

                    val stateSwipeToDismissBoxState = rememberSwipeToDismissBoxState(
                        confirmValueChange = {
                            if (it == SwipeToDismissBoxValue.EndToStart) {
                                onDelete(post)
                                true
                            } else false
                        }
                    )

                    SwipeToDismissBox(
                        modifier = Modifier.animateItem(),
                        state = stateSwipeToDismissBoxState,
                        backgroundContent = {
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(16.dp)
                                    .background(Color.Red)
                                    .padding(end = 16.dp),

                                contentAlignment = Alignment.CenterEnd
                            ) {
                                Icon(
                                    Icons.Default.Delete,
                                    contentDescription = null,
                                )
                            }
                        },
                        enableDismissFromStartToEnd = false,
                    ) {
                        PostCard(post = post) {
                            onClick.invoke(post, it)
                        }
                    }


                }
            }
        }
    }


}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AppBar(drawerState: DrawerState) {
    val scope = rememberCoroutineScope()
    TopAppBar(
        title = {
            Text("Top AppBar")
        },
        navigationIcon = {
            IconButton(onClick = {
                scope.launch {
                    drawerState.apply {
                        when {
                            isClosed -> {
                                open()
                            }

                            isOpen -> {
                                close()
                            }
                        }

                    }

                }


            }) {
                Icon(
                    Icons.Rounded.Menu,
                    contentDescription = null,
                )
            }

        },

        actions = {
            IconButton(onClick = {}) {
                Icon(
                    Icons.Rounded.MoreVert,
                    contentDescription = null,
                )
            }

        }

    )
}

