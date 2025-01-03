package br.applabbs.composecomponents.ui.theme.home

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.applabbs.composecomponents.R
import br.applabbs.composecomponents.ui.theme.Green30

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeApp(navHostController: NavHostController){

    val context = LocalContext.current
    var expanded by remember { mutableStateOf(false) }
    val scrollBehavier = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = Modifier
            .nestedScroll(scrollBehavier.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.compose_app_name),
                        textAlign = TextAlign.Justify,
                        fontSize = 22.sp,
                        maxLines = 1
                    )
                },
                scrollBehavior = scrollBehavier,
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = Green30,
                    titleContentColor = Color.White
                ),
                actions = {
                    IconButton(
                        onClick = {
                            expanded = true
                            Toast.makeText(context, "Designed by Giovani Leite", Toast.LENGTH_SHORT).show()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.MoreVert,
                            contentDescription = "Open Options",
                            tint = Color.White
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(paddingValues = paddingValues)
        ) {
            CustomCard(
                description = "Spin box as Loading",
                statusMessage = "Last Update: 02/JAN/2025",
                statusType = StatusType.COMPLETED
            ){
                navHostController.navigate(Routes.SPIN_LOADING)
            }

            CustomCard(
                description = "Pulse Animation as Loading box",
                statusMessage = "Last Update: 02/JAN/2025",
                statusType = StatusType.COMPLETED
            ){
                navHostController.navigate(Routes.PULSE_ANIMATION)
            }


            CustomCard(
                description = "Document Scanner with ML Kit",
                statusMessage = "Last Update: 04/Mar/2024",
                statusType = StatusType.COMPLETED
            ){
                navHostController.navigate(Routes.DOCSCAN)
            }

            CustomCard(
                description = "Dialog and Custom Dialog",
                statusMessage = "Last Update: 21/Fev/2024",
                statusType = StatusType.COMPLETED
            ){
                navHostController.navigate(Routes.DIALOG)
            }

            CustomCard(
                description = "Handling list and elements \n(em desenvolvimento)",
                statusMessage = "Last Update: 21/Fev/2024",
                statusType = StatusType.UNDER_DEV
            ){
                navHostController.navigate(Routes.HANDLING_LIST)
            }

            CustomCard(
                description = "Shimmer Effect without Library",
                statusMessage = "Last Update: 25/Fev/2024",
                statusType = StatusType.COMPLETED
            ){
                navHostController.navigate(Routes.SHIMMER_EFFECT)
            }

            CustomCard(
                description = "Swipe effect (or parallax effect)",
                statusMessage = "Last Update: 28/Sep/2023",
                statusType = StatusType.COMPLETED
            ) {
                navHostController.navigate(Routes.SWIPE_EFECT)
            }

            CustomCard(
                description = "Calculadora (IMC = Peso / Altura x Altura)",
                statusMessage = "Last Update: 29/Sep/2023",
                statusType = StatusType.COMPLETED
                ) {
                navHostController.navigate(Routes.CALC_IMC)
            }

            CustomCard(
                description = "Bloco de Notas (with DataStore)",
                statusMessage = "Last Update: 20/Sep/2023",
                statusType = StatusType.COMPLETED
            ) {
                navHostController.navigate(Routes.NOTES)
            }

            CustomCard(
                description = stringResource(id = R.string.instagram_cards),
                statusMessage = "Last Update: 30/Sep/2023",
                statusType = StatusType.COMPLETED
            ) {
                navHostController.navigate(Routes.INSTAGRAM_NEWS)
            }

            CustomCard(
                description = "Bottom Menu Customized ",
                statusMessage = "Last Update: 04/Oct/2023",
                statusType = StatusType.COMPLETED
            ) {
                navHostController.navigate(Routes.BOTTOM_MENU)
            }

            CustomCard(
                description = "Busca CEP (MVVM arch *)",
                statusMessage = "Last Update: 13/Oct/2023",
                statusType = StatusType.COMPLETED
            ) {
                navHostController.navigate(Routes.BUSCA_CEP)
            }

            CustomCard(
                description = "Blink Police",
                statusMessage = "Last Update: 18/Nov/2023",
                statusType = StatusType.COMPLETED
            ) {
                navHostController.navigate(Routes.BLINK_POLICE)
            }

            CustomCard(
                description = "Controle Gastos - Em Desenvolvimento",
                statusMessage = "Last Update: 01/Dez/2023",
                statusType = StatusType.WITH_ERROR
            ) {
                navHostController.navigate(Routes.FINANCE_CONTROL)
            }

            CustomCard(
                description = "Pagina de experiencias",
                statusMessage = "Last Update: 31/Dez/2023",
                statusType = StatusType.UNDER_DEV
            ) {
                navHostController.navigate(Routes.EXPERIENCIAS)
            }

            CustomCard(
                description = "Zoom Image",
                statusMessage = "Last Update: 06/Jan/2024",
                statusType = StatusType.COMPLETED
            ) {
                navHostController.navigate(Routes.ZOOM_IMAGE)
            }

            CustomCard(
                description = "Bottom Layout",
                statusMessage = "Last Update: 10/Jan/2024",
                statusType = StatusType.UNDER_DEV
            ) {
                navHostController.navigate(Routes.BOTTOM_LAYOUT)
            }

            CustomCard(
                description = "LiveData example",
                statusMessage = "Last Update: 29/Jan/2024",
                statusType = StatusType.COMPLETED
            ){
                navHostController.navigate(Routes.LIVE_DATA)
            }

            CustomCard(
                description = "Voice to Text",
                statusMessage = "Last Update: 06/Fev/2024",
                statusType = StatusType.UNDER_DEV
            ){
                navHostController.navigate(Routes.VOICE_TEXT)
            }

            CustomCard(
                description = "Line Graph",
                statusMessage = "Last Update: 06/May/2024",
                statusType = StatusType.UNDER_DEV
            ){
                navHostController.navigate(Routes.LINE_GRAPH)
            }



        }
    }
}

@Preview
@Composable
fun PreviewHome(){
    HomeApp(navHostController = rememberNavController())
}