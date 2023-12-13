package com.capstone.dekat.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {

    private val _isLoggedIn: MutableLiveData<Boolean> = MutableLiveData()
    val isLoggedIn = _isLoggedIn

}
