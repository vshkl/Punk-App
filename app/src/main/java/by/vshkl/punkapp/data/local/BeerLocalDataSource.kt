package by.vshkl.punkapp.data.local

import by.vshkl.punkapp.domain.model.Beer
import by.vshkl.punkapp.framework.db.PunkDatabase
import by.vshkl.punkapp.framework.db.entity.BeerEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.transform

class BeerLocalDataSource(
    private val database: PunkDatabase
) {

    suspend fun insertBeers(beers: List<Beer>) {
        beers.forEach { beer ->
            database.beerDao().insertBeer(
                BeerEntity(
                    id = beer.id,
                    name = beer.name,
                    tagline = beer.tagline,
                    description = beer.description,
                    abv = beer.abv,
                    ibu = beer.ibu,
                    ebc = beer.ebc,
                    ph = beer.ph,
                    imageUrl = beer.imageUrl
                )
            )
        }
    }

    fun observeBeers(): Flow<List<Beer>> {
        return database.beerDao().observeBeers().transform {
            it.map { beerEntity ->
                Beer(
                    id = beerEntity.id,
                    name = beerEntity.name,
                    tagline = beerEntity.tagline,
                    description = beerEntity.description,
                    abv = beerEntity.abv,
                    ibu = beerEntity.ibu,
                    ebc = beerEntity.ebc,
                    ph = beerEntity.ph,
                    imageUrl = beerEntity.imageUrl
                )
            }
        }
    }
}
