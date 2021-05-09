package com.example.zad1.di

import com.example.zad1.model.AnimalCounter
import com.example.zad1.viewmodels.AnimalCounterViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModules = module {
    single<AnimalCounter> { AnimalCounter() }
}

val viewModelModule = module {
    viewModel<AnimalCounterViewModel> { AnimalCounterViewModel(get()) }
}