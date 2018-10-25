package com.noox.words.words.ui.list

import com.noox.words.words.data.Word
import com.noox.words.words.domain.CreateWordUseCase
import com.noox.words.words.domain.GetAllWordsUseCase
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Default

class WordListViewModel(
    private val getAllWords: GetAllWordsUseCase,
    private val createWord: CreateWordUseCase
) : ViewModel() {

  private val job = Job()
  private val scope = CoroutineScope(Default + job)

  fun getAllWords() = getAllWords.invoke()

  fun onAddWordButtonClick() {
    scope.launch {
      createWord(Word("new", "nuevo"))
    }
  }

  override fun onCleared() {
    super.onCleared()
    job.cancel()
  }
}
