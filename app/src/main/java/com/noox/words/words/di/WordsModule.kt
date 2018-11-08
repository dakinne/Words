package com.noox.words.words.di

import com.noox.words.core.db.WordDatabase
import com.noox.words.words.data.WordLocalDataSource
import com.noox.words.words.data.WordRepository
import com.noox.words.words.domain.CreateWordUseCase
import com.noox.words.words.domain.GetAllWordsUseCase
import com.noox.words.words.ui.form.WordFormViewModel
import com.noox.words.words.ui.list.WordListViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val wordsModule = module {

    viewModel { WordListViewModel(get(), get()) }
    viewModel { WordFormViewModel(get()) }

    single { GetAllWordsUseCase(get()) }
    single { CreateWordUseCase(get()) }
    single { WordRepository(get()) }
    single { WordLocalDataSource(get()) }
    single { get<WordDatabase>().wordDao() }
}
