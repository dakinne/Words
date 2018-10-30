package com.noox.words.core

import android.app.Application
import com.noox.words.core.di.appModule
import com.noox.words.words.di.wordsModule
import org.koin.android.ext.android.startKoin

class WordsApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(appModule, wordsModule))
    }
}
