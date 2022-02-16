package com.intelligence.cleanarchichtecture.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.intelligence.domain.usecase.GetUserNameUseCase
import com.intelligence.domain.model.UserDomain
import com.intelligence.domain.usecase.SaveUserNameUseCase

/**
 * Created by Osman Boy on 22.09.2021.
 **/
class UserViewModel(
    private val saveUserNameUseCase: SaveUserNameUseCase,
    private val getUserNameUseCase: GetUserNameUseCase
) : ViewModel() {


    val isSaveData get() = _isResultSave
    private val _isResultSave = MutableLiveData<Boolean>()

    val userInfoData get() = _userInfoData
    private val _userInfoData = MutableLiveData<String>()


    fun load() {
        val user = getUserNameUseCase()
        _userInfoData.value = "${user.firstname} ${user.lastname}"
    }

    fun save(firstname: String, lastname: String) {

        val user = UserDomain( firstname, lastname)
        val isSave = saveUserNameUseCase( user)
        _isResultSave.value = isSave

    }


}