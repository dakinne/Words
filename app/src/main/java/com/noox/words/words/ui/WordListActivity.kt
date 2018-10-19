package com.noox.words.words.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.noox.words.R
import com.noox.words.databinding.WordListActivityBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class WordListActivity : AppCompatActivity() {

  private val viewModel by viewModel<WordListViewModel>()

  private lateinit var binding: WordListActivityBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = DataBindingUtil.setContentView(this, R.layout.word_list_activity)

    val adapter = WordListAdapter()
    binding.wordList.adapter = adapter

    viewModel.getAllWords().observe(this, Observer {
      adapter.setWords(it)
    })
  }
}