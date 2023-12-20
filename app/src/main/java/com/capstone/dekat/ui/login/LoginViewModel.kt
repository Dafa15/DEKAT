package com.capstone.dekat.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.capstone.dekat.data.TapisRepository

class LoginViewModel (private val tapisRepository: TapisRepository): ViewModel() {

    private val _isLoggedIn: MutableLiveData<Boolean> = MutableLiveData()
    val isLoggedIn = _isLoggedIn

}
