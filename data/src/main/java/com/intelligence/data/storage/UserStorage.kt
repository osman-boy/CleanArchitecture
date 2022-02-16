package com.intelligence.data.storage

import com.intelligence.data.model.UserData
import com.intelligence.domain.model.UserDomain

/**
 * Created by Osman Boy on 22.09.2021.
 **/
interface UserStorage {

    fun get(): UserData

    fun save(userData: UserData):Boolean
}