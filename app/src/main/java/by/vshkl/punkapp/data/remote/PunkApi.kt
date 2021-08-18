package by.vshkl.punkapp.data.remote

import by.vshkl.punkapp.data.remote.dto.BeerDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PunkApi {

    @GET("beers")
    suspend fun getBeers(@Query("page") page: Int, @Query("per_page") perPage: Int): List<BeerDto>

    @GET("beers/{id}")
    suspend fun getBeer(@Path("id") id: Int): BeerDto
}
