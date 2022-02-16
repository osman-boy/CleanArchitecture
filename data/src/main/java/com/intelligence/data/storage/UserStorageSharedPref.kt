package com.intelligence.data.storage

import android.content.Context
import android.content.SharedPreferences
import com.intelligence.data.model.UserData

const val NAME = "name"
const val LAST_NAME = "lastname"
const val DEFAULT_LAST_NAME = "default last name"
const val DEFAULT_FIRST_NAME = "default last name"
const val SHARED_PREFS_NAME = "storage"

/**
 * Created by Osman Boy on 22.09.2021.
 **/
class UserStorageSharedPref(context: Context) : UserStorage {

    private val storage: SharedPreferences = context.getSharedPreferences(
        SHARED_PREFS_NAME,
        Context.MODE_PRIVATE
    )

    override fun get(): UserData {
        val name = storage.getString(NAME, DEFAULT_FIRST_NAME) ?: DEFAULT_FIRST_NAME
        val lastName = storage.getString(LAST_NAME, DEFAULT_FIRST_NAME) ?: DEFAULT_LAST_NAME
        return UserData(firstname = name, lastname = lastName)
    }

    override fun save(userData: UserData): Boolean {
        storage.edit().putString(NAME, userData.firstname).apply()
        storage.edit().putString(LAST_NAME, userData.lastname).apply()
        return true
    }
}