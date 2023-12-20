package com.capstone.dekat.data.remote.response

import com.google.gson.annotations.SerializedName

data class StoreTapisResponse(

	@field:SerializedName("StoreTapisResponse")
	val storeTapisResponse: List<StoreTapisResponseItem>
)

data class StoreTapisResponseItem(

	@field:SerializedName("createdAt")
	val createdAt: String,

	@field:SerializedName("latitude")
	val latitude: Double,

	@field:SerializedName("storeName")
	val storeName: String,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("longitude")
	val longitude: Double,

	@field:SerializedName("updatedAt")
	val updatedAt: String
)
