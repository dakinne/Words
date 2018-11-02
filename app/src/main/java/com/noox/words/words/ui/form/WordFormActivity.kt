package com.noox.words.words.ui.form

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.noox.words.R
import com.noox.words.databinding.WordFormActivityBinding
import initActionBar
import initBinding

class WordFormActivity : AppCompatActivity() {

    private lateinit var binding: WordFormActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = initBinding(R.layout.word_form_activity)

        initActionBar(binding.includedToolbar.toolbar) {
            setTitle(R.string.word_form_title)
            setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}