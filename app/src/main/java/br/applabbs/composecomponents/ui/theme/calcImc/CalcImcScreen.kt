package br.applabbs.composecomponents.ui.theme.calcImc

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
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
fun CalculadoraImcScreen(navHostController: NavHostController){

    val localContext = LocalContext.current
    val calcularImc = CalcularImc()
    var peso by remember { mutableStateOf("") }
    var altura by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Calculadora de IMC",
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
                    IconButton(
                        onClick = {
                            peso = ""
                            altura = ""
                            resultado = ""
                        }
                    ){
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_reload),
                            contentDescription = "refresh",
                            tint = Color.White
                        )
                    }
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
        content = { paddingValues ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),

                content = {
                    Text(
                        text = "Informe os parâmetros",
                        fontSize = 22.sp,
                        textAlign = TextAlign.Justify,
                        color = Color.Black,
                        modifier = Modifier.padding(20.dp)
                    )

                    OutlinedTextField(
                        value = peso,
                        onValueChange = {
                            peso = it
                        },
                        label = {
                            Text(text = "Peso (KG)")
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
                            .padding(20.dp, 0.dp, 20.dp, 0.dp),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        )
                    )

                    OutlinedTextField(
                        value = altura,
                        onValueChange = {
                            altura = it
                        },
                        label = {
                            Text(text = "Altura (cm)")
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
                            .padding(20.dp, 0.dp, 20.dp, 0.dp),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        )
                    )
                    Button(
                        onClick = {
                            if(peso.isEmpty() || altura.isEmpty()){
                                Toast.makeText(localContext, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
                            }else{
                                calcularImc.calcularImc(peso = peso, altura = altura)
                                resultado = calcularImc.resultadoImc()
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp)
                            .height(50.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Green30,
                            contentColor = Color.White
                        )
                    ) {
                        Text(
                            text = "Calcular IMC",
                            color = Color.White,
                            fontSize = 22.sp
                            )
                    }

                    Text(
                        text = resultado,
                        fontSize = 22.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                }
            )
        }
    )
}

@Preview
@Composable
fun PreviewCalcImc(){
    CalculadoraImcScreen(navHostController = rememberNavController())
}