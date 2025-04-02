package com.example.coffeecounter

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.spotify.sdk.android.auth.AuthorizationClient
import com.spotify.sdk.android.auth.AuthorizationRequest
import com.spotify.sdk.android.auth.AuthorizationResponse

class SpotifyRedirectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        handleAuthResponse()
    }

    private fun handleAuthResponse() {
        val response = AuthorizationClient.getResponse(
            resultCode,
            intent
        )

        when (response.type) {
            AuthorizationResponse.Type.TOKEN -> {
                // Successfully authenticated
                SpotifyManager.onAuthSuccess(response.accessToken)
            }
            AuthorizationResponse.Type.ERROR -> {
                // Handle error
            }
            else -> {
                // Other cases
            }
        }
        finish()
    }

    companion object {
        fun createAuthRequest(): AuthorizationRequest {
            return AuthorizationRequest.Builder(
                SpotifyManager.CLIENT_ID,
                AuthorizationResponse.Type.TOKEN,
                SpotifyManager.REDIRECT_URI
            )
                .setScopes(arrayOf("streaming"))
                .setCustomParam("show_dialog", "true")
                .build()
        }
    }
}