package by.vshkl.punkapp.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FermentationDto(
    @Json(name = "temp") val temp: TempDto
)
