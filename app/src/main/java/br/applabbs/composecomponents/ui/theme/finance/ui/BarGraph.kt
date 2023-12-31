package br.applabbs.composecomponents.ui.theme.finance.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.applabbs.composecomponents.ui.theme.Green30

@Composable
fun BarGraph(
    uiState: ExpenseUiState,
    maxValue: Int,
    barTitle: String = "Year: 2023"
){

    val barGraphHeight by remember { mutableStateOf(140.dp) }
    val barGraphWidth by remember { mutableStateOf(30.dp) }
    val barData = uiState.barData

    Column(
        modifier = Modifier
            .padding(top = 10.dp, start = 4.dp, end = 4.dp)
            .fillMaxWidth()
            .background(Color.White),

    ) {

        Text(
            text = barTitle,
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .padding(top = 10.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .height(barGraphHeight),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // graph
            barData.values.forEach {
                Box(
                    modifier = Modifier
                        .padding(start = 0.dp, bottom = 0.dp, end = 0.dp)
                        .width(barGraphWidth)
                        .clip(RoundedCornerShape(2.dp))
                        .fillMaxHeight(it)
                        .background(Green30)
                        .clickable {

                        }
                ){
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.Center),
                        text = it.toString(),
                        fontSize = 8.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }

        // Scale X-Axis
        Row(
            modifier = Modifier
                .padding(start = 0.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            barData.labels.forEach {
                Text(
                    modifier = Modifier.width(barGraphWidth),
                    text = it,
                    fontSize = 8.sp,
                    textAlign = TextAlign.Center
                )
            }

        }

    }

}


@Preview(showBackground = false)
@Composable
fun PreviewBarGraph(){
    BarGraph(
        uiState = ExpenseUiState(),
        maxValue = 1000,
        barTitle = "Year: 2023"
    )
}