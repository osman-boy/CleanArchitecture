package com.intelligence.cleanarchichtecture.di

import com.intelligence.cleanarchichtecture.presentation.UserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel<UserViewModel> {
        UserViewModel(
            getUserNameUseCase = get(),
            saveUserNameUseCase = get()
        )
    }

}