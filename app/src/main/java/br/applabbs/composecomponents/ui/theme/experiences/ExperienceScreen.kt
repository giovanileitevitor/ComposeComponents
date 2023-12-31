package br.applabbs.composecomponents.ui.theme.experiences

import android.graphics.Color
import android.widget.CheckBox
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExperienceScreen(navHostController: NavHostController){

    val red = remember { mutableStateOf(true)}
    val green = remember { mutableStateOf(true)}
    val blue = remember { mutableStateOf(true)}

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
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
                .padding(top = 16.dp)
        ){
            if(red.value){
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(androidx.compose.ui.graphics.Color.Red)
                )
            }
            if(green.value){
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(32.dp)
                        .background(androidx.compose.ui.graphics.Color.Green)
                )
            }
            if(blue.value){
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(64.dp)
                        .background(androidx.compose.ui.graphics.Color.Blue)
                )
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