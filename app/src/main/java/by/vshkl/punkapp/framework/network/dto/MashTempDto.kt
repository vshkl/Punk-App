package by.vshkl.punkapp.framework.network.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MashTempDto(
    @Json(name = "duration") val duration: Int,
    @Json(name = "temp") val temp: TempDto
)
