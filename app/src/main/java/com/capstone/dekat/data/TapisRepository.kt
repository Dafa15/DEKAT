package com.capstone.dekat.data

import com.capstone.dekat.data.remote.retrofit.ApiService

class TapisRepository  private constructor(
    private val apiService: ApiService
) {

    fun getTapis () {

    }

    fun getScanResult () {

    }

    companion object {
        @Volatile
        private var instance: TapisRepository? = null
        fun getInstance(
            apiService: ApiService
        ): TapisRepository =
            instance ?: synchronized(this) {
                instance ?: TapisRepository(apiService)
            }.also { instance = it }
    }

}