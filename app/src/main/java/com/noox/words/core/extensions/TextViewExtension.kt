package com.noox.words.core.extensions

import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView

/**
 * Add an action which will be invoked before the text changed
 */
fun TextView.doBeforeTextChanged(
        action: (text: CharSequence?, start: Int, count: Int, after: Int) -> Unit
) {
    addTextChangedListener(beforeTextChanged = action)
}

/**
 * Add an action which will be invoked when the text is changing
 */
fun TextView.doOnTextChanged(
        action: (text: CharSequence?, start: Int, count: Int, after: Int) -> Unit
) {
    addTextChangedListener(onTextChanged = action)
}

/**
 * Add an action which will be invoked after the text changed
 */
fun TextView.doAfterTextChanged(
        action: (text: Editable?) -> Unit
) {
    addTextChangedListener(afterTextChanged = action)
}

/**
 * Add a text changed listener to this TextView using the provided actions
 */
fun TextView.addTextChangedListener(
        beforeTextChanged: ((text: CharSequence?, start: Int, count: Int, after: Int) -> Unit)? = null,
        onTextChanged: ((text: CharSequence?, start: Int, count: Int, after: Int) -> Unit)? = null,
        afterTextChanged: ((text: Editable?) -> Unit)? = null
) {
    addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            afterTextChanged?.invoke(s)
        }

        override fun beforeTextChanged(text: CharSequence?, start: Int, count: Int, after: Int) {
            beforeTextChanged?.invoke(text, start, count, after)
        }

        override fun onTextChanged(text: CharSequence?, start: Int, before: Int, count: Int) {
            onTextChanged?.invoke(text, start, before, count)
        }
    })
}
