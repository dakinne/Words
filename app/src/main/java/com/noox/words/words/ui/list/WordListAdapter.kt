package com.noox.words.words.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.noox.words.databinding.WordListItemBinding
import com.noox.words.words.data.Word

class WordListAdapter : RecyclerView.Adapter<WordListViewHolder>() {

    private var items: List<Word> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordListViewHolder {

        return WordListViewHolder(
            WordListItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: WordListViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun setWords(words: List<Word>) {
        this.items = words
        notifyDataSetChanged()
    }
}
