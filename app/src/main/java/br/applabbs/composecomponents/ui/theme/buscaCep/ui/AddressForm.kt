package br.applabbs.composecomponents.ui.theme.buscaCep.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.applabbs.composecomponents.ui.theme.Green30
import br.applabbs.composecomponents.ui.theme.buscaCep.utils.MaskTransformation


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddressForm(
    uiState: AddressFormUiState,
    onSearchAddressClick: (String) -> Unit,
    modifier: Modifier = Modifier,
){

    var cep by remember { mutableStateOf("") }

    Column(
        modifier = modifier.fillMaxSize()
    ){
        when{
            uiState.isError -> {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Red)
                ) {
                    Text(
                        text = "Falha ao buscar o endereço",
                        Modifier
                            .padding(8.dp)
                            .align(Alignment.Center),
                        color = Color.White
                    )
                }
            }
            uiState.isLoading -> {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()) {
                    CircularProgressIndicator(
                        Modifier
                            .padding(8.dp)
                            .align(Alignment.Center)
                    )
                }
            }
        }

        Column(
            modifier = Modifier.verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            OutlinedTextField(
                value = cep,
                onValueChange = { it ->
                    cep = it.filter { it.isDigit() }
                },
                label = {
                    Text(text = "CEP (xxxxx-xxx)")
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    cursorColor = Green30,
                    focusedBorderColor = Green30,
                    unfocusedBorderColor = Color.Gray
                ),
                textStyle = TextStyle(color = Color.Black, fontSize = 18.sp),
                maxLines = 1,
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp, bottom = 10.dp, top = 20.dp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                visualTransformation = MaskTransformation(),
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "search button",
                        modifier = Modifier.clickable {
                            onSearchAddressClick(cep)
                        }
                    )
                },
            )

            Form(
                form = uiState
            )

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Form(form: AddressFormUiState){

    val addressTextFieldModifier = Modifier.fillMaxWidth()
    var logradouro by remember(form.logradouro) { mutableStateOf(form.logradouro) }
    var bairro by remember(form.bairro) { mutableStateOf(form.bairro) }
    var estado by remember(form.estado) { mutableStateOf(form.estado) }
    var numero by remember { mutableStateOf(form.complemento) }
    var cidade by remember(form.cidade) { mutableStateOf(form.cidade) }
    var ddd by remember(form.ddd) { mutableStateOf(form.ddd) }

    Column(
        modifier = Modifier.fillMaxSize()
            .padding(start = 10.dp, end = 10.dp, bottom = 10.dp, top = 10.dp),
    ) {
        TextField(
            value = logradouro,
            onValueChange = {
                logradouro = it
            },
            addressTextFieldModifier,
            label = {
                Text(text = "Logradouro")
            }
        )

        TextField(
            value = numero,
            onValueChange = {
                numero = it
            },
            addressTextFieldModifier,
            label = {
                Text(text = "Número")
            }
        )

        TextField(
            value = bairro,
            onValueChange = {
                bairro = it
            },
            addressTextFieldModifier,
            label = {
                Text(text = "Bairro")
            }
        )

        TextField(
            value = cidade,
            onValueChange = {
                cidade = it
            },
            addressTextFieldModifier,
            label = {
                Text(text = "Cidade")
            }
        )

        TextField(
            value = estado,
            onValueChange = {
                estado = it
            },
            addressTextFieldModifier,
            label = {
                Text(text = "Estado")
            }
        )

        TextField(
            value = ddd,
            onValueChange = {
                ddd = it
            },
            addressTextFieldModifier,
            label = {
                Text(text = "DDD")
            }
        )
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewBuscaCepForm(){
    AddressForm(
        uiState = AddressFormUiState(),
        onSearchAddressClick = {}
    )
}