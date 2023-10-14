package br.applabbs.composecomponents.ui.theme.buscaCep.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import br.applabbs.composecomponents.ui.theme.buscaCep.repository.AddressRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AddressViewModel(
    private val repository: AddressRepository
): ViewModel() {


    private val _uiState = MutableStateFlow(AddressFormUiState())
    val uiState = _uiState.asStateFlow()

    suspend fun findAddress(cep: String){
        _uiState.update{
            it.copy(
                isLoading = true,
                isError = false
            )
        }

        _uiState.update{
            try{
                repository.findAddress(cep = cep)
                    .toAddressFormUiState()
            }catch (t: Throwable){
                Log.e("AddressViewModel", "findAddress: ", t)
                _uiState.value.copy(
                    isError = true,
                    isLoading = false
                )
            }
        }
    }

}