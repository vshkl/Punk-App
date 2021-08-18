package by.vshkl.punkapp.domain.model

data class Beer(
    val id: Int,
    val name: String,
    val tagline: String,
    val description: String,
    val abv: Double,
    val ibu: Int,
    val ebc: Int,
    val ph: Double,
    val imageUrl: String,
)
