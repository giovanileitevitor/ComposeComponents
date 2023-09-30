package br.applabbs.composecomponents.ui.theme.instagramNews

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.applabbs.composecomponents.ui.theme.Green90

@Composable
fun InstagramNewsScreen(navHostController: NavHostController){
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
    ){
        Column {
            ChipSection(
                cards = cards
            )
        }
    }
}

@Composable
private fun ChipSection(
    cards: List<InstagramCard>
){
    var selectedChipIndex by remember { mutableIntStateOf(0) }
    val context = LocalContext.current.applicationContext

    LazyRow {
        items(cards.size) {
            Box(
                modifier = Modifier.padding(0.dp),
                contentAlignment = Alignment.Center
            ){
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .padding(start = 15.dp, top = 15.dp, bottom = 15.dp, end = 5.dp)
                        .clickable {
                            selectedChipIndex = it
                            Toast.makeText(context, "City selected: " + "${cards[it].cardName}", Toast.LENGTH_SHORT).show()
                        }
                        .clip(CircleShape)
                        .border(
                            width = if (selectedChipIndex == it) 4.dp else 2.dp,
                            color =  if (selectedChipIndex == it) Green90 else Color.Gray,
                            shape = CircleShape
                        )
                        .height(80.dp)
                        .width(80.dp)
                ) {
                    Image(
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier.fillMaxSize(),
                        painter = painterResource(cards[it].cardImage),
                        contentDescription = "image"
                    )
                }

                Text(
                    text = cards[it].cardName,
                    textAlign = TextAlign.Justify,
                    fontSize = 12.sp,
                    color = Color.White,
                    maxLines = 1,
                    modifier = Modifier
                        .align(alignment = Alignment.Center)

                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewButtons(){
    InstagramNewsScreen(navHostController = rememberNavController())
}