package by.vshkl.punkapp.framework.network.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HopDto(
    @Json(name = "add") val add: String,
    @Json(name = "amount") val amount: AmountDto,
    @Json(name = "attribute") val attribute: String,
    @Json(name = "name") val name: String
)
