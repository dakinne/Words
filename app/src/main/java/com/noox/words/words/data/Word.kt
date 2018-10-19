package com.noox.words.words.data

import androidx.room.Entity

@Entity(tableName = "words", primaryKeys = ["english", "spanish"])
data class Word(val english: String, val spanish: String)
