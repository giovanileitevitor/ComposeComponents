package br.applabbs.composecomponents.ui.theme.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.applabbs.composecomponents.R
import br.applabbs.composecomponents.ui.theme.Green30
import br.applabbs.composecomponents.ui.theme.home.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun DialogScreen(
    navHostController: NavHostController
){

    var isDisplayedDialog by remember { mutableStateOf(false)}
    var openGenericDialog by remember { mutableStateOf(false)}
    var openCustomDialog by remember { mutableStateOf(false)}

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Dialog & Custom Dialog",
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

            Button(
                onClick = {
                    isDisplayedDialog = true
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Green30,
                    contentColor = Color.White
                ),
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = "Open Generic Dialog Box")
            }

            Button(
                onClick = {
                    openCustomDialog = true
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Green30,
                    contentColor = Color.White
                ),
                modifier = Modifier.padding(8.dp)
            ){
                Text(text = "Open Custom Dialog Box")
            }

            if(isDisplayedDialog){
                Dialog(
                    onDismissRequest = { isDisplayedDialog = false }
                ) {
                   Column(
                       modifier = Modifier
                           .clip(RoundedCornerShape(15.dp))
                           .size(400.dp)
                           .background(Color.White)
                           .padding(16.dp)
                   ) {
                       Text(text = "Generic Dialog Box")
                       Spacer(modifier = Modifier.size(16.dp))
                       Text(text = "Texto padrao de alerta ou subtítulo")
                       Button(
                           onClick = {
                               isDisplayedDialog = false
                           }
                       ){
                            Text(text = "OK")
                       }
                   }
                }
            }

            if(openCustomDialog){
                Dialog(
                    onDismissRequest = { openCustomDialog = false },
                    properties = DialogProperties(
                        dismissOnBackPress = true,
                        dismissOnClickOutside = true
                    ),
                ) {
                    Column(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .height(200.dp)
                            .fillMaxWidth()
                            .background(Color.White)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(28.dp)
                                .background(Color.Green)
                        ){
                            Text(
                                text = "Custom Alert Dialog",
                                textAlign = TextAlign.Center,
                                fontSize = 14.sp,
                                color = Color.Black,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(end = 8.dp, top = 4.dp, start = 8.dp)
                            )
                        }
                        Text(
                            text = "Insira aqui a mensagem desejada para subititle do Alert !!",
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(14.dp)
                        )
                        Button(
                            onClick = { openCustomDialog = false },
                            modifier = Modifier
                                .padding(start = 14.dp, end = 14.dp)
                                .align(Alignment.CenterHorizontally),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Green,
                                contentColor = Color.Black
                            ),
                        ){
                            Text(text = "Close Custom Dialog")
                        }

                    }
                    
                }
            }

        }
    }
}

//@Composable
//private fun CustomDialog(
//    title: String,
//    onClick: () -> Unit
//){
//
//}
//
//@Preview(showBackground = false)
//@Composable
//private fun PreviewCustomDialog(){
//    CustomDialog(
//        title = "Custom Dialog Title"
//    ) {
//
//    }
//}

@Preview(showBackground = false)
@Composable
private fun PreviewDialogScreen(){
    DialogScreen(navHostController = rememberNavController())
}
