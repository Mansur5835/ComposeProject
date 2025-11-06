package com.example.firstjcomposeproject.ui.screens

import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firstjcomposeproject.R
import com.example.firstjcomposeproject.ui.theme.FirstJComposeProjectTheme
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKAuthenticationResult
import com.vk.api.sdk.auth.VKScope
import com.vk.id.AccessToken
import com.vk.id.VKID
import com.vk.id.VKIDAuthFail
import com.vk.id.auth.VKIDAuthCallback
import com.vk.id.auth.VKIDAuthParams
import kotlinx.coroutines.launch
import androidx.core.net.toUri
import com.vk.api.sdk.ui.VKWebViewAuthActivity
import com.vk.sdk.api.friends.FriendsService
import com.vk.sdk.api.users.dto.UsersFieldsDto


@Composable
fun LoginScreen(
    onLoginSuccess: (AccessToken) -> Unit,
) {

    val context = LocalContext.current

    val authCalBack = object : VKIDAuthCallback {
        override fun onAuth(accessToken: AccessToken) {
            onLoginSuccess(accessToken)
        }

        override fun onFail(fail: VKIDAuthFail) {
            Log.d("LoginScreen", "authCalBack onFail ${fail.description}")

        }
    }
    val scope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            modifier = Modifier.wrapContentHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Image(
                modifier = Modifier.size(100.dp),
                painter = painterResource(
                    R.drawable.vk_logo
                ),
                contentDescription = null,
            )
            Spacer(
                modifier = Modifier.height(100.dp)
            )
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {



                    scope.launch {
                        VKID.instance.authorize(
                            callback = authCalBack,
                            params = VKIDAuthParams {
                                scopes = setOf(
                                    "wall",
                                    "friends",
                                    "offline",
                                )
                            },
                        )
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                )

            ) {
                Text(
                    "Log in",
                    color = Color.White,
                )
            }
        }

    }

}


@Preview
@Composable
private fun PreviewL() {
    FirstJComposeProjectTheme(
        darkTheme = false
    ) {
        LoginScreen() {}
    }

}


@Preview
@Composable
private fun PreviewD() {
    FirstJComposeProjectTheme(
        darkTheme = true
    ) {
        LoginScreen() {}
    }

}