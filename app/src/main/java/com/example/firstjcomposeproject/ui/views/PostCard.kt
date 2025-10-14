package com.example.firstjcomposeproject.ui.views

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
import com.example.firstjcomposeproject.R
import com.example.firstjcomposeproject.ui.theme.FirstJComposeProjectTheme
import java.time.LocalTime

@Composable
fun PostCard(painter: Painter? = null) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Header(painter = painter)
            Spacer(modifier = Modifier.height(8.dp))
            Body(
                painter = painter
            )
            Spacer(modifier = Modifier.height(8.dp))
            Footer()
        }
    }
}


@Composable
private fun Footer() {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {

        IconsWithText(
            icon = R.drawable.eye,
            text = "916",
            modifier = Modifier.weight(1F)
        )


        Row(
            modifier = Modifier.weight(1F),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconsWithText(
                icon = R.drawable.share,
                text = "7"
            )

            IconsWithText(
                icon = R.drawable.comment,
                text = "8"
            )

            IconsWithText(
                icon = R.drawable.heart,
                text = "23"
            )

        }


    }
}

@Composable
private fun Body(painter: Painter? = null) {
    Column() {
        Text(stringResource(R.string.template_text))
        Spacer(modifier = Modifier.height(4.dp))
        AppImage(
            contentScale = ContentScale.FillWidth,
            painter = painter,
            data = "https://plus.unsplash.com/premium_photo-1698405202949-1313de4a437d?ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&q=80&w=1640"
        )
    }
}


@Composable
private fun Header(painter: Painter? = null) {

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        AppImage(
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape),
            data = "https://images.unsplash.com/photo-1578589385251-045f05a6faa5?ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&q=80&w=1760",
            painter = painter,
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            modifier = Modifier.weight(1F)
        ) {
            Text(
                "/dev/null",
                color = MaterialTheme.colorScheme.onSurface,
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                LocalTime.now().toString(),
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
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
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

@Preview
@Composable
private fun PostCardPreviewLight() {
    FirstJComposeProjectTheme(darkTheme = false) {
        PostCard(
            painter = painterResource(
                R.drawable.usgs_an18
            )
        )
    }
}


@Preview
@Composable
private fun PostCardPreviewDark() {

    FirstJComposeProjectTheme(darkTheme = true) {
        PostCard(
            painter = painterResource(
                R.drawable.usgs_an18
            )
        )
    }

}




