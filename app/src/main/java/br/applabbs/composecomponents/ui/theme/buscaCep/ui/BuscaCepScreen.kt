package br.applabbs.composecomponents.ui.theme.buscaCep.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.applabbs.composecomponents.R
import br.applabbs.composecomponents.ui.theme.Green30
import br.applabbs.composecomponents.ui.theme.home.Routes
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BuscaCepScreen(navHostController: NavHostController) {

    var cep by remember { mutableStateOf("") }
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val viewModel = koinViewModel<AddressViewModel>()
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Buscador de Endereços",
                        textAlign = TextAlign.Justify,
                        fontSize = 22.sp,
                        maxLines = 1,
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = Green30,
                    titleContentColor = Color.White
                ),
                actions = {

                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navHostController.navigate(Routes.HOME)
                        }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_back),
                            contentDescription = "Voltar",
                            tint = Color.White
                        )
                    }
                }
            )
        }
    ){ paddingValues ->
        AddressForm(
            modifier = Modifier.padding(paddingValues = paddingValues),
            uiState = uiState ,
            onSearchAddressClick = { cep ->
                scope.launch {
                    viewModel.findAddress(cep = cep)
                }
            }
        )
    }
}

@Preview
@Composable
fun PreviewBuscaCep(){
    BuscaCepScreen(navHostController = rememberNavController())
}
