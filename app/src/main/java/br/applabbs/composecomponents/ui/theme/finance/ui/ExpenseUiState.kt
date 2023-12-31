package br.applabbs.composecomponents.ui.theme.finance.ui

import br.applabbs.composecomponents.ui.theme.finance.domain.BarData
import br.applabbs.composecomponents.ui.theme.finance.domain.getFakeMonths
import br.applabbs.composecomponents.ui.theme.finance.domain.getFakeValues

data class ExpenseUiState(
    val barData: BarData = BarData(values = getFakeValues(), labels = getFakeMonths()),
    val isLoading: Boolean = false,
    val isError: Boolean = false
)
