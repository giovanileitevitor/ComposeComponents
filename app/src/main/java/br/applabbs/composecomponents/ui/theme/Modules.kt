package br.applabbs.composecomponents.ui.theme

import br.applabbs.composecomponents.ui.theme.buscaCep.ui.AddressViewModel
import br.applabbs.composecomponents.ui.theme.buscaCep.data.AddressRepository
import br.applabbs.composecomponents.ui.theme.finance.data.FinanceRepository
import br.applabbs.composecomponents.ui.theme.finance.ui.FinanceViewModel
import br.applabbs.composecomponents.ui.theme.livedata.LiveViewModel
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
    singleOf(::FinanceRepository)
    viewModelOf(::AddressViewModel)
    viewModelOf(::FinanceViewModel)
    viewModelOf(::LiveViewModel)
}

val networkRetrofitModule = module {

}

val networkModule = module {
    single{
        HttpClient(Android){
            install(Logging) {
                level = LogLevel.BODY
            }
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                })
            }
        }
    }

}