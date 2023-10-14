package br.applabbs.composecomponents.ui.theme.buscaCep.repository

import br.applabbs.composecomponents.ui.theme.buscaCep.ui.AddressFormUiState
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AddressResponse(
    val logradouro: String,
    val bairro: String,
    @SerialName("localidade")
    val cidade: String,
    @SerialName("uf")
    val estado: String
) {
    fun toAddressFormUiState() = AddressFormUiState(
        logradouro = logradouro,
        bairro = bairro,
        cidade = cidade,
        estado = estado,
        isLoading = false,
        isError = false
    )
}