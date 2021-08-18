package by.vshkl.punkapp.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MaltDto(
    @Json(name = "amount") val amount: AmountDto,
    @Json(name = "name") val name: String
)
