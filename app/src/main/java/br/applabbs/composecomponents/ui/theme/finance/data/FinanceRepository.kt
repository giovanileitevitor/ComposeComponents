package br.applabbs.composecomponents.ui.theme.finance.data

import br.applabbs.composecomponents.ui.theme.finance.domain.BarData
import br.applabbs.composecomponents.ui.theme.finance.domain.getFakeMonths
import br.applabbs.composecomponents.ui.theme.finance.domain.getFakeValues

class FinanceRepository(

) {

    suspend fun getBarData(): BarData{
        return BarData(
            values = getFakeValues(),
            labels = getFakeMonths()
        )
    }

}