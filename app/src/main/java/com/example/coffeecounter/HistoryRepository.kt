package com.example.coffeecounter

import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*

class HistoryRepository(private val historyDao: HistoryDao) {

    suspend fun saveDailyCount(count: Int) {
        withContext(Dispatchers.IO) {
            val today = Calendar.getInstance().apply {
                set(Calendar.HOUR_OF_DAY, 0)
                set(Calendar.MINUTE, 0)
                set(Calendar.SECOND, 0)
                set(Calendar.MILLISECOND, 0)
            }.time

            val existingEntry = historyDao.getEntryByDate(today)
            if (existingEntry != null) {
                historyDao.update(HistoryEntry(existingEntry.id, today, count))
            } else {
                historyDao.insert(HistoryEntry(date = today, count = count))
            }
        }
    }

    fun getWeeklyHistory(): LiveData<List<HistoryEntry>> {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_YEAR, -7)
        return historyDao.getEntriesAfterDate(calendar.time)
    }

    fun getMonthlyHistory(): LiveData<List<HistoryEntry>> {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.MONTH, -1)
        return historyDao.getEntriesAfterDate(calendar.time)
    }
}