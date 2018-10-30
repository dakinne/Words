package com.noox.words.words.domain

import androidx.lifecycle.LiveData
import com.noox.words.words.data.WordRepository
import com.noox.words.words.data.Word

class GetAllWordsUseCase(private val wordsRepository: WordRepository) {

    operator fun invoke(): LiveData<List<Word>> = wordsRepository.getAllWords()
}
