package com.noox.words.words.ui.form

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.noox.words.R
import com.noox.words.databinding.WordFormActivityBinding
import androidx.databinding.DataBindingUtil

class WordFormActivity : AppCompatActivity() {

  private lateinit var binding: WordFormActivityBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = DataBindingUtil.setContentView(this, R.layout.word_form_activity)

    setSupportActionBar(binding.includedToolbar.toolbar)
  }

}