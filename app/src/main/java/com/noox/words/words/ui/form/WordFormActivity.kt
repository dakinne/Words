package com.noox.words.words.ui.form

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.noox.words.R
import com.noox.words.core.extensions.doAfterTextChanged
import com.noox.words.databinding.WordFormActivityBinding
import initActionBar
import initBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import showKeyboard

class WordFormActivity : AppCompatActivity() {

    private val viewModel by viewModel<WordFormViewModel>()

    private lateinit var binding: WordFormActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = initBinding(R.layout.word_form_activity)
        binding.setLifecycleOwner(this)
        binding.viewModel = viewModel

        initActionBar(binding.includedToolbar.toolbar) {
            setTitle(R.string.word_form_title)
            setDisplayHomeAsUpEnabled(true)
        }

        viewModel.uiState.observe(this, Observer {
            val uiModel = it ?: return@Observer

            uiModel.addWordSuccess?.apply {
                if (consumed) return@apply
                consume()?.let {
                    setResult(Activity.RESULT_OK)
                    finish() }
            }

            uiModel.showError?.apply {
                if (consumed) return@apply
                consume()?.let { showError() }
            }
        })

        binding.english.doAfterTextChanged {
            onWordDataChanged()
        }

        binding.spanish.doAfterTextChanged {
            onWordDataChanged()
        }

        binding.addButton.setOnClickListener {
            viewModel.addWord(binding.english.text.toString(), binding.spanish.text.toString())
        }

        showKeyboard()
    }

    private fun showError() {
        Toast.makeText(this, R.string.word_form_add_word_has_failed, Toast.LENGTH_SHORT).show()
    }

    private fun onWordDataChanged() {
        viewModel.wordDataChanged(binding.english.text.toString(), binding.spanish.text.toString())
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}