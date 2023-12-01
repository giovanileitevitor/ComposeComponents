package br.applabbs.composecomponents.ui.theme.blinkPolice

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.applabbs.composecomponents.R
import br.applabbs.composecomponents.ui.theme.Green30
import br.applabbs.composecomponents.ui.theme.home.Routes
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BlinkPoliceScreen(navHostController: NavHostController){

    var isVisible by remember { mutableStateOf(true) }
    var currentColor by remember { mutableStateOf(Color.Red) }

    var isAlternate = remember { mutableStateOf(false) }
    var backgroundColor = remember { mutableStateOf(Color.Red) }


    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Pisca Pisca Policia",
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
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                modifier = Modifier.padding(10.dp),
                onClick = {
                    isAlternate.value = !isAlternate.value
                },
                icon = {
                    if(isAlternate.value){
                        Icon(Icons.Filled.Close, "Stop Blink")
                    } else{
                        Icon(Icons.Filled.PlayArrow, "Start Blink")
                    }
                },
                text = {
                    Text(text = if(!isAlternate.value){
                        stringResource(id = R.string.blink_on)
                    } else {
                        stringResource(id = R.string.blink_off)
                    })
                },
            )
        }
    ){ paddingValues ->

        Column (
            modifier = Modifier.padding(paddingValues = paddingValues)
        ){

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(backgroundColor.value)
            )

            LaunchedEffect(isAlternate.value) {
                if (isAlternate.value) {
                    while (true) {
                        backgroundColor.value = if (backgroundColor.value == Color.Red) {
                            Color.Blue
                        } else {
                            Color.Red
                        }

                        delay(200)
                    }
                }
            }
        }

    }

}

@Preview
@Composable
fun PreviewBlinkPolice(){
    BlinkPoliceScreen(navHostController = rememberNavController())
}