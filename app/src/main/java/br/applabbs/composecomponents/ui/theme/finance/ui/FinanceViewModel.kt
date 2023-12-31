package br.applabbs.composecomponents.ui.theme.finance.ui

import androidx.lifecycle.ViewModel
import br.applabbs.composecomponents.ui.theme.finance.data.FinanceRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class FinanceViewModel(
    private val repository: FinanceRepository
): ViewModel() {

    private val _uiState = MutableStateFlow(ExpenseUiState())
    val uiState = _uiState.asStateFlow()

    suspend fun getBarData(){
        _uiState.update{
            it.copy(
                isLoading = true,
                isError = false
            )
        }

        _uiState.update {
            try {
               repository.getBarData()
                   .toExpenseUiState()
            }catch (t: Throwable){
                _uiState.value.copy(
                    isError = true,
                    isLoading = false
                )
            }
        }
    }

}