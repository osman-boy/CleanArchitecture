package com.intelligence.domain.usecase

import com.intelligence.domain.model.UserDomain
import com.intelligence.domain.repository.UserRepository

/**
 * Created by Osman Boy on 22.09.2021.
 **/
class GetUserNameUseCase(private val repository: UserRepository) {

   operator fun invoke(): UserDomain {
        return repository.getUser()
    }
}