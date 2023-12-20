package com.capstone.dekat.ui.maps

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.capstone.dekat.data.remote.response.StoreTapisResponse
import com.capstone.dekat.data.remote.response.StoreTapisResponseItem
import com.capstone.dekat.data.remote.retrofit.ApiConfig
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MapsViewModel: ViewModel() {

    suspend fun getLocation(): List<StoreTapisResponseItem> {
        val client = ApiConfig.getApiService().getStoreLocation()

        return client
    }
}



