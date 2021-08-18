package by.vshkl.punkapp.data.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BeerDto(
    @Json(name = "abv") val abv: Double,
    @Json(name = "attenuation_level") val attenuationLevel: Int,
    @Json(name = "boil_volume") val boilVolume: AmountDto,
    @Json(name = "brewers_tips") val brewersTips: String,
    @Json(name = "contributed_by") val contributedBy: String,
    @Json(name = "description") val description: String,
    @Json(name = "ebc") val ebc: Int,
    @Json(name = "first_brewed") val firstBrewed: String,
    @Json(name = "food_pairing") val foodPairing: List<String>,
    @Json(name = "ibu") val ibu: Int,
    @Json(name = "id") val id: Int,
    @Json(name = "image_url") val imageUrl: String,
    @Json(name = "ingredients") val ingredients: IngredientsDto,
    @Json(name = "method") val method: MethodDto,
    @Json(name = "name") val name: String,
    @Json(name = "ph") val ph: Double,
    @Json(name = "srm") val srm: Int,
    @Json(name = "tagline") val tagline: String,
    @Json(name = "target_fg") val targetFg: Int,
    @Json(name = "target_og") val targetOg: Int,
    @Json(name = "volume") val volume: AmountDto
)
