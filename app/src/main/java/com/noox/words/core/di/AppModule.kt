package com.noox.words.core.di

import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.noox.words.core.db.WordDatabase
import com.noox.words.words.data.Word
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.module
import java.util.concurrent.Executors

val appModule = module {

  // Room Database instance
  single {
    Room.databaseBuilder(androidApplication(), WordDatabase::class.java, "word-db")
        .addCallback(object : RoomDatabase.Callback() {
          override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            Executors.newSingleThreadExecutor().execute {
              val wordDao = get<WordDatabase>().wordDao()
              wordDao.insert(Word("one", "uno"))
              wordDao.insert(Word("two", "dos"))
              wordDao.insert(Word("three", "tres"))
              wordDao.insert(Word("four", "cuatro"))
            }
          }
        })
        .build()
  }
}
