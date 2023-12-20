package com.capstone.dekat.data.remote.response

import com.google.gson.annotations.SerializedName


data class ListTapisResponse (
    @field:SerializedName("id")
    val id: String,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("thumbnail")
    val thumbnail: String,

    @field:SerializedName("signification")
    val signification: String,

    @field:SerializedName("utility")
    val utility: String,

    @field:SerializedName("description")
    val description: String
)