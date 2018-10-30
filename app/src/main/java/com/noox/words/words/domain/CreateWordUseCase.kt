package com.noox.words.words.domain

import com.noox.words.words.data.WordRepository
import com.noox.words.words.data.Word

class CreateWordUseCase(private val wordsRepository: WordRepository) {
    operator fun invoke(word: Word) = wordsRepository.insert(word)
}
