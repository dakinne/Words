package com.noox.words.words.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface WordDao {

    @Insert
    fun insert(word: Word)

    @Query("SELECT * FROM words ORDER BY english ASC")
    fun getAll(): LiveData<List<Word>>
}
