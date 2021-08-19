package by.vshkl.punkapp.framework.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = BeerEntity.TABLE_NAME)
data class BeerEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val tagline: String,
    val description: String,
    val abv: Double,
    val ibu: Double,
    val imageUrl: String,
) {

    companion object {
        const val TABLE_NAME = "beers"
    }
}
