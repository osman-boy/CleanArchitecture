package com.intelligence.data.repository


import com.intelligence.data.storage.UserStorage
import com.intelligence.data.model.UserData
import com.intelligence.domain.model.UserDomain
import com.intelligence.domain.repository.UserRepository

/**
 * Created by Osman Boy on 22.09.2021.
 **/
class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {

    override fun getUser(): UserDomain {
        return mapToDomain(userStorage.get())
    }

    override fun saveUser(userDomain: UserDomain): Boolean {
        return userStorage.save(mapToData(userDomain))
    }


    private fun mapToDomain(userData: UserData): UserDomain {
        return UserDomain(userData.firstname, userData.lastname)
    }

    private fun mapToData(userDomain: UserDomain): UserData {
        return UserData(userDomain.firstname, userDomain.lastname)
    }


}