package com.noox.words.words.data

import androidx.lifecycle.LiveData

class WordLocalDataSource(private val dao: WordDao) {

  fun insert(word: Word) = dao.insert(word)

  fun getAllWords(): LiveData<List<Word>> = dao.getAll()
}
