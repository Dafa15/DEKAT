package com.capstone.dekat.data.remote.response

data class DetailTapisResponse(
	val createdAt: String,
	val thumbnail: String,
	val images: List<ImagesItem>,
	val name: String,
	val utility: String,
	val description: String,
	val id: String,
	val signification: String,
	val updatedAt: String
)

data class ImagesItem(
	val createdAt: String,
	val imageUrl: String,
	val id: String,
	val tapisId: String,
	val updatedAt: String
)

