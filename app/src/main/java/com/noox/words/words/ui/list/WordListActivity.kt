package com.noox.words.words.ui.list

import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.noox.words.R
import com.noox.words.databinding.WordListActivityBinding
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.noox.words.core.ui.EventObserver
import com.noox.words.words.ui.form.WordFormActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class WordListActivity : AppCompatActivity() {

  private val wordListViewModel by viewModel<WordListViewModel>()

  private lateinit var binding: WordListActivityBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = DataBindingUtil.setContentView(this, R.layout.word_list_activity)
    binding.viewModel = wordListViewModel

    val adapter = WordListAdapter()
    binding.wordList.adapter = adapter

    wordListViewModel.getAllWords().observe(this, Observer {
      adapter.setWords(it)
    })

    wordListViewModel.createNewWord.observe(this, EventObserver { openWordForm() })
  }

  private fun openWordForm() = startActivity(Intent(this, WordFormActivity::class.java))
}