package com.intelligence.cleanarchichtecture.di

import com.intelligence.domain.usecase.GetUserNameUseCase
import com.intelligence.domain.usecase.SaveUserNameUseCase
import org.koin.dsl.module


val domainModule = module {

    factory<SaveUserNameUseCase> { SaveUserNameUseCase(repository = get()) }

    factory<GetUserNameUseCase> { GetUserNameUseCase(repository = get()) }
}