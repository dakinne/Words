package com.noox.words.words.di

import com.noox.words.core.db.WordDatabase
import com.noox.words.words.data.WordLocalDataSource
import com.noox.words.words.data.WordRepository
import com.noox.words.words.domain.GetAllWordsUseCase
import com.noox.words.words.ui.WordListViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val wordsModule = module {

  viewModel { WordListViewModel(get()) }

  single { GetAllWordsUseCase(get()) }
  single { WordRepository(get()) }
  single { WordLocalDataSource(get()) }
  single { get<WordDatabase>().wordDao() }
}
