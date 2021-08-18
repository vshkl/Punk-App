package by.vshkl.punkapp.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class IngredientsDto(
    @Json(name = "hops") val hops: List<HopDto>,
    @Json(name = "malt") val malt: List<MaltDto>,
    @Json(name = "yeast") val yeast: String
)
