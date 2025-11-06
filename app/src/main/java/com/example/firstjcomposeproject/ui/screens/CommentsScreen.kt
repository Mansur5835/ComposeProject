package com.example.firstjcomposeproject.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.firstjcomposeproject.ui.viewmodel.CommentsState
import com.example.firstjcomposeproject.ui.viewmodel.CommentsViewModel
import com.example.firstjcomposeproject.ui.viewmodel.CommentsViewModelFactory
import com.example.firstjcomposeproject.domein.FeedPost
import com.example.firstjcomposeproject.domein.PostComment
import com.example.firstjcomposeproject.ui.views.AppImage


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommentsScreen(
    feedPost: FeedPost,
    viewModel: CommentsViewModel = viewModel(
        factory = CommentsViewModelFactory(feedPost)
    ),
    popBack: () -> Unit
) {


    println("start")
    val commentsState by viewModel.commentsState.collectAsStateWithLifecycle()
    println("end")

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Comments for post id: ${feedPost.id}")
                },
                navigationIcon = {
                    IconButton(onClick = popBack) {
                        Icon(
                            Icons.Default.ArrowBack,
                            contentDescription = null,
                        )
                    }
                },
            )
        }
    ) {

        if (commentsState is CommentsState.Initial) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            LazyColumn(
                modifier = Modifier.padding(
                    top = it.calculateTopPadding(),
                    start = 8.dp,
                    end = 8.dp,
                )
            ) {
                items(
                    items = (commentsState as CommentsState.Comments).comments
                ) { comment ->
                    Item(comment)
                }

            }
        }

    }
}


@Composable
private fun Item(comment: PostComment) {

    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        AppImage(
            modifier = Modifier
                .size(32.dp)
                .clip(CircleShape),
            data = comment.avatar,
            contentScale = ContentScale.Crop,

            )
        Spacer(
            modifier = Modifier.width(8.dp)
        )
        Column {
            Text(
                "${comment.authorName} CommentId: ${comment.id}",
                fontSize = 14.sp
            )
            Spacer(
                modifier = Modifier.height(4.dp)
            )
            Text(
                comment.commentText,
                fontSize = 12.sp
            )
            Spacer(
                modifier = Modifier.height(4.dp)
            )
            Text(
                comment.publicDate,
                fontSize = 12.sp
            )

        }

    }
}






















