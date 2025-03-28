package com.example.coffeecounter.data

import androidx.lifecycle.LiveData
import androidx.room.*
import java.util.*

@Dao
interface HistoryDao {
    @Insert
    suspend fun insert(entry: HistoryEntry)

    @Update
    suspend fun update(entry: HistoryEntry)

    @Query("SELECT * FROM history_entries WHERE date = :date LIMIT 1")
    suspend fun getEntryByDate(date: Date): HistoryEntry?

    @Query("SELECT * FROM history_entries WHERE date >= :date ORDER BY date DESC")
    fun getEntriesAfterDate(date: Date): LiveData<List<HistoryEntry>>

    @Query("SELECT * FROM history_entries ORDER BY date DESC")
    fun getAllEntries(): LiveData<List<HistoryEntry>>

    @Query("SELECT SUM(count) FROM history_entries WHERE date >= :date")
    fun getTotalCountSince(date: Date): LiveData<Int>
}