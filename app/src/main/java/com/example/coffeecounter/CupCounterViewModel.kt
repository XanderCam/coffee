package com.example.coffeecounter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coffeecounter.data.HistoryEntry
import kotlinx.coroutines.launch
import java.util.*

class CupCounterViewModel(
    private val repository: HistoryRepository
) : ViewModel() {
    private val _cupCount = MutableLiveData(0)
    val cupCount: LiveData<Int> = _cupCount

    private val _currentQuote = MutableLiveData<String>()
    val currentQuote: LiveData<String> = _currentQuote

    private val lastCupTime = MutableLiveData<Date?>(null)
    private val tauntMessages = listOf(
        "Slow down there, coffee cowboy!",
        "That's enough caffeine for one day!",
        "Your heart might explode!",
        "Maybe switch to decaf?"
    )

    init {
        loadInitialQuote()
    }

    fun addCup() {
        _cupCount.value = (_cupCount.value ?: 0) + 1
        lastCupTime.value = Date()
        viewModelScope.launch {
            repository.saveDailyCount(_cupCount.value ?: 0)
        }
    }

    fun resetCount() {
        _cupCount.value = 0
        lastCupTime.value = null
    }

    fun shouldTauntUser(): Boolean {
        val lastTime = lastCupTime.value ?: return false
        val timeDiff = Date().time - lastTime.time
        return (_cupCount.value ?: 0) > 5 || timeDiff < 30 * 60 * 1000
    }

    fun getRandomTaunt(): String {
        return tauntMessages.random()
    }

    fun updateDailyQuote() {
        _currentQuote.value = QuoteManager.getRandomQuote()
    }

    private fun loadInitialQuote() {
        _currentQuote.value = QuoteManager.getRandomQuote()
    }

    fun getWeeklyHistory(): LiveData<List<HistoryEntry>> {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_YEAR, -7)
        return repository.getEntriesAfterDate(calendar.time)
    }
}