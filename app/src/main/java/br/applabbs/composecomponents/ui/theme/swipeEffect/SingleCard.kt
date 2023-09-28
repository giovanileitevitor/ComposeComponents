package br.applabbs.composecomponents.ui.theme.swipeEffect

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.applabbs.composecomponents.R
import br.applabbs.composecomponents.ui.theme.Green30

@Composable
fun SingleCard(
    title: String = "",
    @DrawableRes image: Int,
    modifier: Modifier
){
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Green30
        ),
        shape = RoundedCornerShape(20.dp),
        modifier = modifier
            .fillMaxWidth()
            .height(180.dp)
            .padding(10.dp)
    ){

        Box(
            modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
        ){
            Image(
                painter = painterResource(id = R.drawable.ic_city_1),
                modifier = Modifier.fillMaxSize(),
                contentDescription = "city 1",
                contentScale = ContentScale.Crop
            )

            Text(
                text = title,
                fontSize = 24.sp,
                color = Color.White,
                modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                textAlign = TextAlign.Center
            )
        }




    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSingleCard(){
    SingleCard(image = R.drawable.ic_city_1, title = "City 1", modifier = Modifier)
}