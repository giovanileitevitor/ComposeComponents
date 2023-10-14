package br.applabbs.composecomponents.ui.theme.di

import br.applabbs.composecomponents.ui.theme.buscaCep.ui.AddressViewModel
import br.applabbs.composecomponents.ui.theme.buscaCep.repository.AddressRepository
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json


val appModule = module {
    singleOf(::AddressRepository)
    viewModelOf(::AddressViewModel)
}

val networkModule = module {
    single{
        HttpClient(Android){
            install(Logging) {
                level = LogLevel.ALL
            }
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                })
            }
        }
    }

}