package br.applabbs.composecomponents.ui.theme.home

import android.icu.text.SimpleDateFormat
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import java.util.Date

@Composable
fun CustomCard(description: String, status: String, onClick: () -> Unit){
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
                        colors = listOf(Green30, Green90),
                        startX = 10f,
                        endX = 3000f
                    )
                )
            ) {
                Text(
                    text = status,
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
                modifier = Modifier.padding(8.dp).fillMaxSize(),
                textAlign = TextAlign.Justify,
                fontSize = 16.sp,
                maxLines = 2
            )
        }
    )
}

@Preview(
    name = "MeuComopnentePreview",
    showBackground = true,
    backgroundColor = 0xFFBDCBDB,
)
@Composable
internal fun MeuComopnentePreview(){

    val date = SimpleDateFormat("dd-MM-yyyy'")
    val currentDateAndTime = date.format(Date())
    CustomCard(
        description = "Meu Componente",
        status = currentDateAndTime,
        onClick = { }
    )
}
