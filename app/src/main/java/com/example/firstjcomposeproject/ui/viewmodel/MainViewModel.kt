package com.example.firstjcomposeproject.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKAuthenticationResult
import com.vk.id.AccessToken
import com.vk.id.VKID
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel() {
    private val _authState = MutableStateFlow<AuthState>(AuthState.Initial)
    val authState = _authState.asStateFlow()


    init {
        val accessToken = VKID.instance.accessToken;

        println("accessToken ${accessToken?.token}")
        _authState.value =
            if (accessToken != null) AuthState.Authorized else AuthState.NotAuthorized
    }


    fun performAuthResult(accessToken: AccessToken) {
        _authState.value = AuthState.Authorized
    }


}


sealed class AuthState {
    object Authorized : AuthState()
    object NotAuthorized : AuthState()
    object Initial : AuthState()
}