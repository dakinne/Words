package com.noox.words.words.data

import androidx.lifecycle.LiveData
import com.noox.words.core.data.Result

class WordLocalDataSource(private val dao: WordDao) {

    fun insert(word: Word) : Result<Boolean> {
        dao.insert(word)
        return Result.Success(true)
    }

    fun getAllWords(): LiveData<List<Word>> = dao.getAll()
}
