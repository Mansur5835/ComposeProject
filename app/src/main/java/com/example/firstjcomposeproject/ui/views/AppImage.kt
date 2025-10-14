package com.example.firstjcomposeproject.ui.views

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun AppImage(
    modifier: Modifier = Modifier,
    data: String?,
    painter: Painter? = null,
    contentDescription: String? = null,
    contentScale: ContentScale = ContentScale.Fit,
) {
    if (painter != null) {
        Image(
            modifier = modifier,
            painter = painter,
            contentDescription = contentDescription,
            contentScale = contentScale
        )
    } else {
        AsyncImage(
            modifier = modifier,
            model = ImageRequest.Builder(LocalContext.current)
                .data(data)
                .crossfade(true)
                .build(),
            contentDescription = contentDescription,
            contentScale = contentScale
        )
    }
}