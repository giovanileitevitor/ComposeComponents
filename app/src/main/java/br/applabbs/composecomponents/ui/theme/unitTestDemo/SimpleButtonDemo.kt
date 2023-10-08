package br.applabbs.composecomponents.ui.theme.unitTestDemo

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import br.applabbs.composecomponents.R

@Composable
fun SimpleButtonDemo(){

    val textA = stringResource(id = R.string.textA)
    val textB = stringResource(id = R.string.textB)
    val colorA = colorResource(id = R.color.purple_200)
    val colorB = colorResource(id = R.color.teal_700)

    var text by remember{ mutableStateOf(textA)}
    var color by remember { mutableStateOf(colorA) }

    Box(
        modifier = Modifier.fillMaxSize().testTag("BOXTAG"),
        contentAlignment = Alignment.Center
    ){
        Button(
            onClick = {
                if(text == textA) {
                    text = textB
                    color = colorB
                } else{
                    text = textA
                    color = colorB
                }
            }
        ){
            Text(
                text = text,
                color = colorB,
                modifier = Modifier
                    .testTag("TEXTTAG")
            )
        }
    }
}

@Preview
@Composable
fun PreviewSimpleButtonDemo(){
    SimpleButtonDemo()
}