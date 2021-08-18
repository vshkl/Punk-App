package by.vshkl.punkapp

import androidx.room.Room
import by.vshkl.punkapp.data.remote.PunkApi
import by.vshkl.punkapp.framework.db.PunkDatabase
import org.koin.android.ext.koin.androidContext
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

    single {
        Room.databaseBuilder(androidContext(), PunkDatabase::class.java, "punk-db")
            .fallbackToDestructiveMigrationOnDowngrade()
            .build()
    }
}
