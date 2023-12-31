package br.applabbs.composecomponents.ui.theme.finance.domain

import br.applabbs.composecomponents.ui.theme.finance.ui.ExpenseUiState

data class BarData(
    val values: List<Float>,
    val labels: List<String>
){
    fun toExpenseUiState() = ExpenseUiState(
        isLoading = false,
        isError = false,
        barData = BarData(
            values = getFakeValues(),
            labels = getFakeMonths()
        )
    )
}

