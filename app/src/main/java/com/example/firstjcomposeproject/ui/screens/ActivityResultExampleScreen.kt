package com.example.firstjcomposeproject.ui.screens

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.firstjcomposeproject.ui.views.AppImage


@Composable
fun ActivityResultExampleScreen() {

    var imageUri by remember {
        mutableStateOf<Uri?>(null)
    }


    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),

        ) {
        imageUri = it
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),

        verticalArrangement = Arrangement.SpaceBetween,
    ) {

        Box {}


        AsyncImage(
            modifier = Modifier.height(200.dp),
            model = imageUri,
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                launcher.launch("image/*")
            }
        ) {
            Text("Get Image")
        }
    }

}


@Preview
@Composable
private fun Preview() {
    ActivityResultExampleScreen()
}





