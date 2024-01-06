package br.applabbs.composecomponents.ui.theme.home

import android.annotation.SuppressLint
import android.icu.text.SimpleDateFormat
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.applabbs.composecomponents.ui.theme.Green30
import br.applabbs.composecomponents.ui.theme.Green90
import br.applabbs.composecomponents.ui.theme.Red30
import br.applabbs.composecomponents.ui.theme.Red90
import br.applabbs.composecomponents.ui.theme.Yellow30
import br.applabbs.composecomponents.ui.theme.Yellow90
import java.util.Date

@Composable
fun CustomCard(
    description: String,
    statusMessage: String,
    statusType: StatusType = StatusType.COMPLETED,
    onClick: () -> Unit
){

    val colors = when(statusType){
        StatusType.COMPLETED -> listOf(Green30, Green90)
        StatusType.WITH_ERROR -> listOf(Red30, Red90)
        StatusType.UNDER_DEV -> listOf(Yellow30, Yellow90)
    }

    ElevatedCard(
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(8.dp, 4.dp, 8.dp, 4.dp)
            .clickable(enabled = true, onClick = onClick),
        content = {
            Row(modifier = Modifier
                .fillMaxWidth()
                .height(28.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = colors,
                        startX = 10f,
                        endX = 3000f
                    )
                )
            ) {
                Text(
                    text = statusMessage,
                    textAlign = TextAlign.End,
                    fontSize = 12.sp,
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 8.dp, top = 4.dp, start = 8.dp)
                )
            }

            Text(
                text = description,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxSize(),
                textAlign = TextAlign.Justify,
                fontSize = 16.sp,
                maxLines = 2
            )
        }
    )
}

@SuppressLint("SimpleDateFormat")
@Preview(
    name = "MeuComopnentePreview",
    showBackground = true,
    backgroundColor = 0xFFBDCBDB,
)
@Composable
internal fun MeuComopnentePreview(){

    val date = SimpleDateFormat("dd-MM-yyyy'")
    val currentDateAndTime = date.format(Date())
    Column {
        CustomCard(
            description = "Meu Componente - finalizado",
            statusMessage = currentDateAndTime,
            statusType = StatusType.COMPLETED,
            onClick = { }
        )

        CustomCard(
            description = "Meu Componente - em construção",
            statusMessage = currentDateAndTime,
            statusType = StatusType.UNDER_DEV,
            onClick = { }
        )

        CustomCard(
            description = "Meu Componente - com Erro",
            statusMessage = currentDateAndTime,
            statusType = StatusType.WITH_ERROR,
            onClick = { }
        )
    }

}

enum class StatusType{
    COMPLETED,
    UNDER_DEV,
    WITH_ERROR
}
