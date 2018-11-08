package com.noox.words.words.ui.form

import com.noox.words.core.ui.Event

data class WordFormUiModel(
        val enableAddButton: Boolean,
        val addWordSuccess: Event<Boolean>?,
        val showError: Event<Boolean>?
)