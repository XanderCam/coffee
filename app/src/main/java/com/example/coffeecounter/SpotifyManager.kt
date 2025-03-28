package com.example.coffeecounter

import android.content.Context
import com.spotify.android.appremote.api.ConnectionParams
import com.spotify.android.appremote.api.Connector
import com.spotify.android.appremote.api.SpotifyAppRemote
import com.spotify.protocol.types.Track

object SpotifyManager {
    private const val CLIENT_ID = "YOUR_SPOTIFY_CLIENT_ID"
    private const val REDIRECT_URI = "com.example.coffeecounter://auth"
    
    private var spotifyAppRemote: SpotifyAppRemote? = null
    private var initialized = false

    fun initialize(context: Context) {
        if (!initialized) {
            val connectionParams = ConnectionParams.Builder(CLIENT_ID)
                .setRedirectUri(REDIRECT_URI)
                .showAuthView(true)
                .build()

            SpotifyAppRemote.connect(context, connectionParams,
                object : Connector.ConnectionListener {
                    override fun onConnected(appRemote: SpotifyAppRemote) {
                        spotifyAppRemote = appRemote
                        initialized = true
                    }

                    override fun onFailure(throwable: Throwable) {
                        // Handle error
                    }
                })
        }
    }

    fun playCoffeePlaylist() {
        spotifyAppRemote?.playerApi?.play("spotify:playlist:37i9dQZF1DX1uaml3UXYLk") // Coffee House playlist
    }

    fun pausePlayback() {
        spotifyAppRemote?.playerApi?.pause()
    }

    fun getCurrentTrack(callback: (Track?) -> Unit) {
        spotifyAppRemote?.playerApi?.subscribeToPlayerState()?.setEventCallback { 
            callback(it.track) 
        }
    }

    fun disconnect() {
        SpotifyAppRemote.disconnect(spotifyAppRemote)
        initialized = false
    }
}