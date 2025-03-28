package com.example.coffeecounter

import android.app.Application
import com.example.coffeecounter.data.AppDatabase
import com.example.coffeecounter.data.HistoryRepository

class CoffeeCounterApplication : Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { HistoryRepository(database.historyDao()) }

    override fun onCreate() {
        super.onCreate()
        // Initialize quote manager with application context
        QuoteManager.initialize(this)
        
        // Initialize Spotify configuration
        SpotifyManager.initialize(this)
    }
}