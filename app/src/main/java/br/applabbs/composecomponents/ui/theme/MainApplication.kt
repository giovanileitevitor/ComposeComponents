package br.applabbs.composecomponents.ui.theme

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MainApplication: Application(){

    override fun onCreate() {

        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@MainApplication)
            androidFileProperties()

            modules(
                listOf(
                    appModule,
                    networkModule,
                    networkRetrofitModule
                )
            )
        }
    }
}