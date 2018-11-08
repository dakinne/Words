package com.noox.words.words.ui.list

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.noox.words.R
import com.noox.words.databinding.WordListActivityBinding
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.noox.words.core.ui.EventObserver
import com.noox.words.words.ui.form.WordFormActivity
import initActionBar
import initBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class WordListActivity : AppCompatActivity() {

    companion object {
        const val RC_ADD_WORD = 1
    }

    private val wordListViewModel by viewModel<WordListViewModel>()

    private lateinit var binding: WordListActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = initBinding(R.layout.word_list_activity)
        binding.viewModel = wordListViewModel

        initActionBar(binding.includedToolbar.toolbar) {
            setTitle(R.string.word_list_title)
        }

        val adapter = WordListAdapter()
        binding.wordList.adapter = adapter

        wordListViewModel.getAllWords().observe(this, Observer {
            adapter.setWords(it)
        })

        wordListViewModel.createNewWord.observe(this, EventObserver { openWordForm() })
    }

    private fun openWordForm() = startActivityForResult(Intent(this, WordFormActivity::class.java), RC_ADD_WORD)

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (RC_ADD_WORD == requestCode && RESULT_OK == resultCode) {
            Toast.makeText(this, R.string.word_list_word_added_successful, Toast.LENGTH_SHORT).show()
        }
    }
}