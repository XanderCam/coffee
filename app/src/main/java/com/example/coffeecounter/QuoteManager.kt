package com.example.coffeecounter

import android.content.Context
import androidx.annotation.ArrayRes
import kotlin.random.Random

object QuoteManager {
    private var quotes: List<String> = emptyList()
    private var initialized = false

    fun initialize(context: Context) {
        if (!initialized) {
            quotes = context.resources.getStringArray(R.array.coffee_quotes).toList()
            initialized = true
        }
    }

    fun getRandomQuote(): String {
        if (!initialized) throw IllegalStateException("QuoteManager not initialized")
        return quotes[Random.nextInt(quotes.size)]
    }

    fun getQuoteForCount(count: Int): String {
        return when {
            count == 0 -> "You haven't had any coffee today!"
            count < 3 -> "You're just getting started!"
            count < 6 -> "Now we're talking!"
            else -> "Whoa there coffee addict!"
        }
    }
}