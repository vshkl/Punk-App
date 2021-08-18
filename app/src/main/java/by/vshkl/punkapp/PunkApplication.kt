package by.vshkl.punkapp

import android.app.Application
import org.koin.core.context.startKoin

class PunkApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(appModule)
        }
    }
}
