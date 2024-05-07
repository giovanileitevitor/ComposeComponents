package br.applabbs.composecomponents.ui.theme.linegraph

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.applabbs.composecomponents.R
import br.applabbs.composecomponents.ui.theme.Green30
import br.applabbs.composecomponents.ui.theme.home.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun LineGraphScreen(
    navHostController: NavHostController
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Line Graph Without LIB",
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
    ) { paddingValues ->

        val data = listOf(
            Pair("Jan", 111.45),
            Pair("Fev", 111.0),
            Pair("Mar", 113.45),
            Pair("Abr", 112.25),
            Pair("May", 116.45),
            Pair("Jun", 113.35),
            Pair("Jul", 118.65)
//            Pair("Ago", 110.15),
//            Pair("Sep", 113.05),
//            Pair("Oct", 114.25),
//            Pair("Nov", 116.35),
//            Pair("Dec", 117.45)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            LineChart(
                data = data,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .align(CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(40.dp))
            Divider()
        }

    }
}

@Composable
@Preview(showBackground = true)
private fun PreviewLineGraph(){
    LineGraphScreen(navHostController = rememberNavController())
}