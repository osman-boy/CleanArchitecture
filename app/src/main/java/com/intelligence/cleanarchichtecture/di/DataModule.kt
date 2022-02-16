package com.intelligence.cleanarchichtecture.di

import com.intelligence.data.repository.UserRepositoryImpl
import com.intelligence.data.storage.UserStorage
import com.intelligence.data.storage.UserStorageSharedPref
import com.intelligence.domain.repository.UserRepository
import org.koin.dsl.module


val dataModule = module {

    single<UserStorage> { UserStorageSharedPref(context = get()) }

    single<UserRepository> { UserRepositoryImpl(userStorage = get()) }
}