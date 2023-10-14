package br.applabbs.composecomponents.ui.theme.buscaCep.ui

data class AddressFormUiState(
    val logradouro: String = "",
    val bairro: String = "",
    val cidade: String = "",
    val estado: String = "",
    val isLoading: Boolean = false,
    val isError: Boolean = false
)
