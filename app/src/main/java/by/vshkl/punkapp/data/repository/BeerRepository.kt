package by.vshkl.punkapp.data.repository

import by.vshkl.punkapp.data.local.BeerLocalDataSource
import by.vshkl.punkapp.data.remote.BeerRemoteDataSource
import by.vshkl.punkapp.domain.model.Beer
import kotlinx.coroutines.flow.Flow

class BeerRepository(
    private val beerLocalDataSource: BeerLocalDataSource,
    private val beerRemoteDataSource: BeerRemoteDataSource
) {

    private var page = 1

    fun observeBeers(): Flow<List<Beer>> {
        return beerLocalDataSource.observeBeers()
    }

    suspend fun loadBeers() {
        val beers = beerRemoteDataSource.getBeers(page, 20)
        page++
        beerLocalDataSource.insertBeers(beers)
    }
}
