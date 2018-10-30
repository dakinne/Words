package com.noox.words.words.data

class WordRepository(private val wordLocalDataSource: WordLocalDataSource) {

    fun getAllWords() = wordLocalDataSource.getAllWords()

    fun insert(word: Word) = wordLocalDataSource.insert(word)
}