package by.vshkl.punkapp.data.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AmountDto(
    @Json(name = "unit") val unit: String,
    @Json(name = "value") val value: Double
)
