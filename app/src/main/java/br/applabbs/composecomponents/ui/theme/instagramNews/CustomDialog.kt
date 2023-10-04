package br.applabbs.composecomponents.ui.theme.instagramNews

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomDialog(instagramCard: InstagramCard, showDialog: MutableState<Boolean>, onDismiss: () -> Unit){

    if(showDialog.value){
        AlertDialog(
            onDismissRequest = { onDismiss() },
            title = {
                Text(
                    text = instagramCard.cardName,
                    fontSize = 16.sp,
                    color = Color.Black
                )
            },
            text = {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = instagramCard.cardImage),
                        contentDescription = "city name",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .size(80.dp)
                            .padding(8.dp)
                    )

                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        onDismiss()
                    }
                ) {
                    Text("OK")
                }
            }
        )
    }

}

@Preview
@Composable
fun PreviewDialog(){

}