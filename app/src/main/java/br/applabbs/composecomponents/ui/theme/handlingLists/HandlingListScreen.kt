package br.applabbs.composecomponents.ui.theme.handlingLists

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
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
internal fun HandlingListScreen(
    navHostController: NavHostController
){

    var name by remember { mutableStateOf("")}
    var names by remember { mutableStateOf(listOf<String>())}

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Handling List",
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
                .padding(paddingValues = paddingValues)
                .fillMaxWidth()
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp, top = 10.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                OutlinedTextField(
                    value = name,
                    onValueChange = { text ->
                        name = text
                    },
                    modifier = Modifier.weight(1f)
                )

                Spacer(modifier = Modifier.width(10.dp))

                Button(
                    onClick = {
                        if (name.isNotBlank()){
                            names = names + name
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Green30,
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(2.dp)
                ) {
                    Text(text = "ADD")
                }
            }

            LazyColumn(
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp, top = 20.dp)
            ) {
                items(names) { currentName ->
                    Text(
                        text = currentName,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    )
                    Divider()
                }
            }

        }
    }

}

@Preview(showBackground = false)
@Composable
private fun PreviewHandlingListScreen(){
    HandlingListScreen(navHostController = rememberNavController())
}