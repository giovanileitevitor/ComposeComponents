package br.applabbs.composecomponents.ui.theme.buscaCep.ui

data class AddressFormUiState(
    val cep: String = "",
    val logradouro: String = "",
    val complemento: String = "",
    val bairro: String = "",
    val cidade: String = "",
    val estado: String = "",
    val ddd: String = "",
    val isLoading: Boolean = false,
    val isError: Boolean = false
)
