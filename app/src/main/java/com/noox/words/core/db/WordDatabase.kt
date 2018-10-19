package com.noox.words.core.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.noox.words.words.data.WordDao
import com.noox.words.words.data.Word

@Database(entities = [Word::class], version = 1)
abstract class WordDatabase : RoomDatabase() {

    abstract fun wordDao(): WordDao
}
