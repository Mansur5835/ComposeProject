package com.example.firstjcomposeproject.ui.views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstjcomposeproject.R
import com.example.firstjcomposeproject.domein.entity.InstagramModel


@Composable
fun InstagramProfileCard(model: InstagramModel, onClickAction: () -> Unit) {

    Card(
        modifier = Modifier.padding(8.dp),
        shape = RoundedCornerShape(
            topStart = 4.dp,
            topEnd = 4.dp,
        ),
        border = BorderStroke(1.dp, color = MaterialTheme.colorScheme.onSurface),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background
        )
    ) {
        Column(
            modifier = Modifier.padding(vertical = 16.dp)
        ) {
            Header()
            Spacer(modifier = Modifier.height(8.dp))
            Content(model, onClickAction)
        }
    }
}


@Composable
private fun Header() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .background(Color.White)
                .padding(10.dp),
            painter = painterResource(R.drawable.ic_instagram),
            contentDescription = "",
        )
        Texts("6,959", "Posts")
        Texts("436M", "Followers")
        Texts("76", "Following")
    }
}


@Composable
private fun Texts(title: String, context: String) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            title,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive,
            color = MaterialTheme.colorScheme.onSurface,
        )
        Text(
            context,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.onSurface,
        )
    }
}


@Composable
private fun Content(model: InstagramModel, onClickAction: () -> Unit) {


    Column(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        Text(
            "Instagram ${model.id}",
            fontSize = 32.sp,
            fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface,
        )
        Text(
            "#${model.title}",
            color = MaterialTheme.colorScheme.onSurface,
        )
        Text(
            "https//:facebook.com/cr_ronaldo",
            textDecoration = TextDecoration.Underline,
            color = MaterialTheme.colorScheme.primary,
        )
        OutlinedButton(
            onClick = onClickAction,
            shape = RoundedCornerShape(4.dp),
            border = BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.onSurface),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = MaterialTheme.colorScheme.onSurface,
            ),
        ) {
            val text = if (model.isFollowed) "Unfollow" else "Follow"
            Text(text)
        }
    }
}

