package com.capstone.dekat.data.remote.response

import com.google.gson.annotations.SerializedName

data class ScanTapisResponse(

	@field:SerializedName("tapisImage")
	val tapisImage: String,

	@field:SerializedName("tapisName")
	val tapisName: String,

	@field:SerializedName("tapisId")
	val tapisId: String
)
