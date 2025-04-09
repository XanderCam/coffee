package com.example.coffeecounter.data

import androidx.lifecycle.LiveData
import java.util.Date
import com.example.coffeecounter.data.HistoryEntry
import com.example.coffeecounter.data.HistoryDao

class HistoryRepository(private val historyDao: HistoryDao) {

    suspend fun insert(entry: HistoryEntry) {
        historyDao.insert(entry)
    }

    suspend fun update(entry: HistoryEntry) {
        historyDao.update(entry)
    }

    fun getAllEntries(): LiveData<List<HistoryEntry>> {
        return historyDao.getAllEntries()
    }

    fun getEntriesAfterDate(date: Date): LiveData<List<HistoryEntry>> {
        return historyDao.getEntriesAfterDate(date)
    }

    fun getTotalCountSince(date: Date): LiveData<Int> {
        return historyDao.getTotalCountSince(date)
    }
}
