package by.vshkl.punkapp.framework.db

import androidx.room.Database
import androidx.room.RoomDatabase
import by.vshkl.punkapp.framework.db.dao.BeerDao
import by.vshkl.punkapp.framework.db.entity.BeerEntity

@Database(
    entities = [BeerEntity::class],
    version = 1
)
abstract class PunkDatabase : RoomDatabase() {

    abstract fun beerDao(): BeerDao
}
