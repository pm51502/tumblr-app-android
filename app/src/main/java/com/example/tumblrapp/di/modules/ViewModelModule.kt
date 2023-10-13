package com.example.tumblrapp.di.modules

import com.example.tumblrapp.viewmodels.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        HomeViewModel(blogpostRepository = get())
    }
}
