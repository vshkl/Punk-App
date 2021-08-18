package by.vshkl.punkapp

import by.vshkl.punkapp.data.remote.PunkApi
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val appModule = module {
    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl("https://api.punkapi.com/v2/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    single<PunkApi> {
        get<Retrofit>().create(PunkApi::class.java)
    }
}
