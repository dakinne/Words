package com.noox.words.words.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.noox.words.core.ui.Event
import com.noox.words.words.domain.CreateWordUseCase
import com.noox.words.words.domain.GetAllWordsUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Default
import kotlinx.coroutines.Job

class WordListViewModel(
    private val getAllWords: GetAllWordsUseCase,
    private val createWord: CreateWordUseCase
) : ViewModel() {

    private val job = Job()
    private val scope = CoroutineScope(Default + job)

    private val _createNewWord = MutableLiveData<Event<Unit>>()
    val createNewWord: LiveData<Event<Unit>>
        get() = _createNewWord

    // TODO: Use coroutines for get words
    fun getAllWords() = getAllWords.invoke()

    fun addWord() {
        _createNewWord.value = Event(Unit)
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}
