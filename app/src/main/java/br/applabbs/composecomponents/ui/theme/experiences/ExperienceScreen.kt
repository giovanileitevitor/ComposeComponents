package br.applabbs.composecomponents.ui.theme.experiences

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.applabbs.composecomponents.R
import br.applabbs.composecomponents.ui.theme.Green30
import br.applabbs.composecomponents.ui.theme.home.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExperienceScreen(navHostController: NavHostController){

    val red = remember { mutableStateOf(true)}
    val green = remember { mutableStateOf(true)}
    val blue = remember { mutableStateOf(true)}

    val viewModel = viewModel<ExperienceViewModel>()
    val composeColor = viewModel.composeColor
    //val flowColor by viewModel.color.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Experience Screen",
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

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {

            CheckBoxWithLabel(
                label = "red",
                state = red
            )

            CheckBoxWithLabel(
                label = "green",
                state = green
            )

            CheckBoxWithLabel(
                label = "blue",
                state = blue
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 40.dp)
            ) {
                if (red.value) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.Red)
                    )
                }
                if (green.value) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(48.dp)
                            .background(Color.Green)
                    )
                }
                if (blue.value) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(80.dp)
                            .background(Color(composeColor))
                            .clickable {
                                viewModel.generateNewColor()
                                val colorString = String.format("#%08X", composeColor)
                                Log.i("TESTE", colorString)
                            }
                    )
                }
            }
        }
    }
}

@Composable
fun CheckBoxWithLabel(
    label: String,
    state: MutableState<Boolean>
){

    Row(
        modifier = Modifier.clickable {
            state.value = !state.value
        },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = state.value,
            onCheckedChange = {
                state.value = it
            }
        )
        Text(
            text = label,
            modifier = Modifier.padding(start = 8.dp)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewExperienceScreen(){
    ExperienceScreen(navHostController = rememberNavController())
}