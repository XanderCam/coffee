package com.example.coffeecounter.spotify

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
import retrofit2.Retrofit

interface SpotifyApiService {
    @GET("v1/recommendations")
    suspend fun getRecommendations(
        @Header("Authorization") token: String,
        @Query("seed_tracks") trackId: String,
        @Query("limit") limit: Int = 5
    ): Response<RecommendationResponse>
}

data class RecommendationResponse(
    val tracks: List<Track>
)

data class Track(
    val id: String,
    val name: String,
    val artists: List<Artist>,
    val external_urls: Map<String, String>
)

data class Artist(
    val name: String
)