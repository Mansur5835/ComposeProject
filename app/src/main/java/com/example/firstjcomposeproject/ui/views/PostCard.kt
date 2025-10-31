package com.example.firstjcomposeproject.ui.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firstjcomposeproject.PostCardViewModel
import com.example.firstjcomposeproject.R
import com.example.firstjcomposeproject.domein.FeedPost
import com.example.firstjcomposeproject.domein.StatisticItem
import com.example.firstjcomposeproject.domein.StatisticType
import com.example.firstjcomposeproject.getItemByType
import com.example.firstjcomposeproject.ui.theme.FirstJComposeProjectTheme
import java.time.LocalTime

@Composable
fun PostCard(
    modifier: Modifier = Modifier,
    post: FeedPost,
    onClick: (type: StatisticType) -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Header(post)
            Spacer(modifier = Modifier.height(8.dp))
            Body(post)
            Spacer(modifier = Modifier.height(8.dp))
            Footer(
                post.statisticItems,
                onClick = onClick
            )
        }
    }
}


@Composable
private fun Footer(statisticItems: List<StatisticItem>, onClick: (type: StatisticType) -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {

        IconsWithText(
            icon = R.drawable.eye,
            text = statisticItems.getItemByType(StatisticType.VIEW).count.toString(),
            modifier = Modifier.weight(1F),
            onClick = {
                onClick.invoke(StatisticType.VIEW)
            }
        )


        Row(
            modifier = Modifier.weight(1F),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconsWithText(
                icon = R.drawable.share,
                text = statisticItems.getItemByType(StatisticType.SHARES).count.toString(),
                onClick = {

                    onClick.invoke(StatisticType.SHARES)
                }
            )

            IconsWithText(
                icon = R.drawable.comment,
                text = statisticItems.getItemByType(StatisticType.COMMENTS).count.toString(),
                onClick = {

                    onClick.invoke(StatisticType.COMMENTS)
                }
            )

            IconsWithText(
                icon = R.drawable.heart,
                text = statisticItems.getItemByType(StatisticType.LIKES).count.toString(),
                onClick = {

                    onClick.invoke(StatisticType.LIKES)
                }
            )

        }
    }
}


@Composable
private fun Body(post: FeedPost) {
    Column {
        Text(post.contentText)
        Spacer(modifier = Modifier.height(4.dp))
        AppImage(
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.height(200.dp),
            data = post.contentImage,
        )
    }
}


@Composable
private fun Header(post: FeedPost) {

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        AppImage(
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape),
            data = post.avatar,
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            modifier = Modifier.weight(1F)
        ) {
            Text(
                post.communityName,
                color = MaterialTheme.colorScheme.onSurface,
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                post.publicationDate,
                color = MaterialTheme.colorScheme.onBackground,
            )
        }
        IconButton(
            onClick = {},
        ) {
            Icon(
                imageVector = Icons.Rounded.MoreVert,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onBackground,
            )

        }


    }
}


@Composable
private fun IconsWithText(
    icon: Int,
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier.clickable {
            onClick()
        }
    ) {
        Icon(
            modifier = Modifier.size(24.dp),
            painter = painterResource(icon),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text,
            color = MaterialTheme.colorScheme.onBackground
        )

    }

}

//@Preview
//@Composable
//private fun PostCardPreviewLight() {
//    FirstJComposeProjectTheme(darkTheme = false) {
//        PostCard(
//
//        )
//    }
//}
//
//
//@Preview
//@Composable
//private fun PostCardPreviewDark() {
//
//    FirstJComposeProjectTheme(darkTheme = true) {
//        PostCard(
//            painter = painterResource(
//                R.drawable.usgs_an18
//            )
//        )
//    }
//
//}




