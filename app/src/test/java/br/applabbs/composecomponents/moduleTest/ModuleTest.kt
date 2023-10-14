package br.applabbs.composecomponents.moduleTest

import br.applabbs.composecomponents.ui.theme.buscaCep.repository.AddressRepository
import br.applabbs.composecomponents.ui.theme.di.appModule
import br.applabbs.composecomponents.ui.theme.di.networkModule
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.test.KoinTest
import org.koin.test.inject

class ModuleTest: KoinTest {

    val addressRepository : AddressRepository by inject()

    @Test
    fun checkKoinModule(){
        startKoin { modules(appModule)

        }

    }
}