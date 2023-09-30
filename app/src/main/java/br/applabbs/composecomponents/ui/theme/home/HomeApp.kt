package br.applabbs.composecomponents.ui.theme.home

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
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
                        text = "Compose Components",
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
            CustomCard(description = "Swipe effect (or parallax effect)", status = "Last Update: 28/Sep/2023") {
                navHostController.navigate(Routes.SWIPE_EFECT)
            }

            CustomCard(description = "Calc IMC (IMC = Peso / Altura x Altura)", status = "Last Update: 29/Sep/2023") {
                navHostController.navigate(Routes.CALC_IMC)
            }

            CustomCard(description = "Bloco de Notas (with DataStore)", status = "Last Update: 20/Sep/2023") {
                navHostController.navigate(Routes.NOTES)
            }

            CustomCard(description = "Instagram News ", status = "Last Update: 30/Sep/2023") {
                navHostController.navigate(Routes.INSTAGRAM_NEWS)
            }

        }
    }
}

@Preview
@Composable
fun PreviewHome(){
    HomeApp(navHostController = rememberNavController())
}