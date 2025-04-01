package com.example.coffeecounter.spotify

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.core.content.ContextCompat.startActivity

object SpotifyUtils {
    private const val SPOTIFY_PACKAGE = "com.spotify.music"
    private const val SPOTIFY_WEB_URL = "https://open.spotify.com/track/"

    fun openTrackInSpotify(context: Context, trackId: String) {
        try {
            // Try opening in Spotify app first
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("spotify:track:$trackId")
                setPackage(SPOTIFY_PACKAGE)
            }
            startActivity(context, intent, null)
        } catch (e: Exception) {
            // Fallback to web player
            val webIntent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("$SPOTIFY_WEB_URL$trackId")
            }
            startActivity(context, webIntent, null)
        }
    }

    fun getRecommendationLink(trackId: String): String {
        return "https://open.spotify.com/recommendations/$trackId"
    }
}