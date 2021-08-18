package by.vshkl.punkapp.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TempDto(
    @Json(name = "unit") val unit: String,
    @Json(name = "value") val value: Double
)
