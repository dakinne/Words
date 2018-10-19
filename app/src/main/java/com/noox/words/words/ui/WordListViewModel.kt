package com.noox.words.words.ui

import androidx.lifecycle.ViewModel
import com.noox.words.words.domain.GetAllWordsUseCase

class WordListViewModel(
    private val getAllWords: GetAllWordsUseCase
) : ViewModel() {

  fun getAllWords() = getAllWords.invoke()
}
