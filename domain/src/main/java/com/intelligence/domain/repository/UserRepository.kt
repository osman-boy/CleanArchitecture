package com.intelligence.domain.repository

import com.intelligence.domain.model.UserDomain

/**
 * Created by Osman Boy on 22.09.2021.
 **/
interface UserRepository {

    fun getUser(): UserDomain

    fun saveUser(userDomain: UserDomain): Boolean
}