package by.vshkl.punkapp.data.remote

import by.vshkl.punkapp.domain.model.Beer
import by.vshkl.punkapp.framework.network.PunkApi

class BeerRemoteDataSource(
    private val punkApi: PunkApi
) {

    suspend fun getBeers(page: Int, perPage: Int): List<Beer> {
        return punkApi.getBeers(page, perPage)
            .map { beerDto ->
                Beer(
                    id = beerDto.id,
                    name = beerDto.name,
                    tagline = beerDto.tagline,
                    description = beerDto.description,
                    abv = beerDto.abv,
                    ibu = beerDto.ibu,
                    ebc = beerDto.ebc,
                    ph = beerDto.ph,
                    imageUrl = beerDto.imageUrl
                )
            }
    }
}
