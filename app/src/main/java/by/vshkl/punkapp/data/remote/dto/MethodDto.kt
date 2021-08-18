package by.vshkl.punkapp.data.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MethodDto(
    @Json(name = "fermentation") val fermentation: FermentationDto,
    @Json(name = "mash_temp") val mashTemp: List<MashTempDto>,
    @Json(name = "twist") val twist: Any
)
