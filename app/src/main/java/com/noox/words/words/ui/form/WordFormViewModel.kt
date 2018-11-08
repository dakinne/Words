package com.noox.words.words.ui.form

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.noox.words.core.data.Result.Success
import com.noox.words.core.data.Result.Error
import com.noox.words.core.ui.Event
import com.noox.words.words.data.Word
import com.noox.words.words.domain.CreateWordUseCase
import kotlinx.coroutines.*

class WordFormViewModel(
        private val createWord: CreateWordUseCase
) : ViewModel() {

    private val parentJob = Job()
    private val scope = CoroutineScope(Dispatchers.Default + parentJob)
    private var job :Job? = null

    private val _uiState = MutableLiveData<WordFormUiModel>()
    val uiState: LiveData<WordFormUiModel>
        get() = _uiState

    init {
        enableAddWord(false)
    }

    fun addWord(english: String, spanish: String) {
        if (job?.isActive == true) {
            return
        }
        job = launchAddWord(english, spanish)
    }

    private fun launchAddWord(english: String, spanish: String) : Job {
        return scope.launch {
            if (!isWordValid(english, spanish)) {
                return@launch
            }
            val result = createWord(Word(english, spanish))
            withContext(Dispatchers.Main) {
                when (result) {
                    is Success -> emitUiState(addWordSuccess = Event(true))
                    is Error -> emitUiState(showError = Event(true))
                }
            }
        }
    }

    fun wordDataChanged(english: String, spanish: String) {
        enableAddWord(isWordValid(english, spanish))
    }

    private fun isWordValid(english: String, spanish: String): Boolean {
        return english.isNotBlank() && spanish.isNotBlank()
    }

    private fun enableAddWord(enabled: Boolean) {
        emitUiState(enableAddButton = enabled)
    }

    private fun emitUiState(
            enableAddButton: Boolean = false,
            addWordSuccess: Event<Boolean>? = null,
            showError: Event<Boolean>? = null
    ) {
        _uiState.value = WordFormUiModel(enableAddButton, addWordSuccess, showError)
    }
}

