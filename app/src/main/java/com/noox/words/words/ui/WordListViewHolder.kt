package com.noox.words.words.ui

import androidx.recyclerview.widget.RecyclerView
import com.noox.words.databinding.WordListItemBinding
import com.noox.words.words.data.Word

class WordListViewHolder(
    private val binding: WordListItemBinding
) : RecyclerView.ViewHolder(binding.root) {

  fun bind(item: Word) {
    binding.word = item
    binding.executePendingBindings()

    binding.apply {
      word = item
      executePendingBindings()
    }
  }
}
