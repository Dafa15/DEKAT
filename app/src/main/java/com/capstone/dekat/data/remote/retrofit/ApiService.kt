package com.capstone.dekat.data.remote.retrofit

import com.capstone.dekat.data.remote.response.DetailTapisResponse
import com.capstone.dekat.data.remote.response.ListTapisResponse
import com.capstone.dekat.data.remote.response.ScanTapisResponse
import com.capstone.dekat.data.remote.response.StoreTapisResponseItem
import okhttp3.MultipartBody
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path

interface ApiService {

    @GET("tapis")
    suspend fun getTapis(): List<ListTapisResponse>

    @Multipart
    @POST("tapis/scan")
    suspend fun scanTapis (
        @Part file: MultipartBody.Part,
    ): ScanTapisResponse

    @GET("tapis/{tapisId}")
    suspend fun getDetailTapis (
        @Path("tapisId") id : String
    ): DetailTapisResponse

    @GET("area")
    suspend fun getStoreLocation (): List<StoreTapisResponseItem>
}