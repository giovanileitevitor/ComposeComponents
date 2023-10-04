package br.applabbs.composecomponents.ui.theme.instagramNews

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.applabbs.composecomponents.R
import br.applabbs.composecomponents.ui.theme.Green30
import br.applabbs.composecomponents.ui.theme.Green90
import br.applabbs.composecomponents.ui.theme.home.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InstagramNewsScreen(navHostController: NavHostController){

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Instagram Cards",
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
        modifier = Modifier
    ){ paddingValues ->

        Box(
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize()
                .padding(paddingValues = paddingValues)
        ){
            Column {
                ChipSection(
                    cards = cards
                )
            }
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
            Column(
                modifier = Modifier.padding(0.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(start = 10.dp, top = 10.dp, bottom = 5.dp, end = 10.dp)
                        .size(80.dp)
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
                    textAlign = TextAlign.Center,
                    fontSize = 14.sp,
                    color = Color.Black,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.width(80.dp)
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