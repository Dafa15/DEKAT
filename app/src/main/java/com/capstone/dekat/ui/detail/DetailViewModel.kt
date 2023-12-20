package com.capstone.dekat.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.capstone.dekat.data.remote.response.DetailTapisResponse
import com.capstone.dekat.data.remote.retrofit.ApiConfig

class DetailViewModel: ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    suspend fun getDetailTapis(id : String): DetailTapisResponse {
        _isLoading.value = true
        val client = ApiConfig.getApiService().getDetailTapis(id)
        _isLoading.value = false
        return client
    }
}