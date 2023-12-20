package com.capstone.dekat.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.capstone.dekat.data.remote.response.ListTapisResponse
import com.capstone.dekat.data.remote.retrofit.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel: ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    suspend fun getList(): List<ListTapisResponse> {
        _isLoading.value = true
        val client = ApiConfig.getApiService().getTapis()
        _isLoading.value = false

        return client
    }


}