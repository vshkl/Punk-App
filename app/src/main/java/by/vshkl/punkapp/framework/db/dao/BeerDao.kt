package by.vshkl.punkapp.framework.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import by.vshkl.punkapp.framework.db.entity.BeerEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BeerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBeer(beerEntity: BeerEntity)

    @Query("SELECT * FROM ${BeerEntity.TABLE_NAME}")
    fun observeBeers(): Flow<List<BeerEntity>>

    @Query("SELECT * FROM ${BeerEntity.TABLE_NAME} WHERE id LIKE :id LIMIT 1")
    fun observeBeer(id: Int): Flow<BeerEntity?>
}
