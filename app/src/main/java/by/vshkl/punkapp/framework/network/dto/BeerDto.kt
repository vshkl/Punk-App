package by.vshkl.punkapp.framework.network.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BeerDto(
    @Json(name = "id") val id: Int,
    @Json(name = "name") val name: String,
    @Json(name = "tagline") val tagline: String,
    @Json(name = "description") val description: String,
    @Json(name = "abv") val abv: Double? = 0.0,
    @Json(name = "ibu") val ibu: Double? = 0.0,
    @Json(name = "image_url") val imageUrl: String
)
