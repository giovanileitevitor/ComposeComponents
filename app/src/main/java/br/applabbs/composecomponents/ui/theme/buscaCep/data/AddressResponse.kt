package br.applabbs.composecomponents.ui.theme.buscaCep.data

import br.applabbs.composecomponents.ui.theme.buscaCep.ui.AddressFormUiState
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class AddressResponse(
    val cep: String,
    val logradouro: String,
    @SerializedName("complemento") val complemento: String,
    val bairro: String,
    val localidade: String,
    val uf: String,
    val ddd: String
) {
    fun toAddressFormUiState() = AddressFormUiState(
        cep = cep,
        logradouro = logradouro,
        complemento = complemento,
        bairro = bairro,
        cidade = localidade,
        estado = uf,
        ddd = ddd,
        isLoading = false,
        isError = false
    )
}