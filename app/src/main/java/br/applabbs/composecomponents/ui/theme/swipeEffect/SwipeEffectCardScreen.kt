package br.applabbs.composecomponents.ui.theme.swipeEffect

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.applabbs.composecomponents.R
import br.applabbs.composecomponents.ui.theme.Green30
import br.applabbs.composecomponents.ui.theme.Green90
import com.alexstyl.swipeablecard.Direction
import com.alexstyl.swipeablecard.ExperimentalSwipeableCardApi
import com.alexstyl.swipeablecard.rememberSwipeableCardState
import com.alexstyl.swipeablecard.swipableCard

@OptIn(ExperimentalSwipeableCardApi::class)
@Composable
fun SwipeEffectCardScreen(navHostController: NavHostController){

    val context = LocalContext.current
    val state = rememberSwipeableCardState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Green30, Green90)
                )
            )
    ){

        Box {
            val states = cities.reversed().map {
                it to rememberSwipeableCardState()
            }

            var hint by remember {
                mutableStateOf("Swipe or press any button")
            }


            Hint(text = hint)

            val scope = rememberCoroutineScope()

            Box(
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxSize()
                    .aspectRatio(1f)
                    .align(Alignment.Center)
            ){
                states.forEach { ( matchCity, state ) ->
                    if(state.swipedDirection == null){
                        CityCard(
                            modifier = Modifier
                                .fillMaxSize()
                                .swipableCard(
                                    state = state,
                                    blockedDirections = listOf(Direction.Down),
                                    onSwiped = {
                                        val a = 10
                                    },
                                    onSwipeCancel = {
                                        hint = "Canceled the swipe"
                                    }
                                ),
                            matchCity = matchCity
                        )
                    }

                    LaunchedEffect(matchCity, state.swipedDirection){
                        if (state.swipedDirection != null) {
                            hint = "Last action: \n"  + stringFrom(state.swipedDirection!!)
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun CityCard(
    modifier: Modifier,
    matchCity: MatchCity,
) {
    Card(
        shape = RoundedCornerShape(20.dp),
        modifier = modifier
    ) {
        Box {
            Image(
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(matchCity.cityImage),
                contentDescription = null
            )

            Scrim(Modifier.align(Alignment.BottomCenter))

            Column(
                modifier = Modifier.align(Alignment.TopStart)
            ) {
                Text(text = matchCity.cityName,
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(start = 20.dp, bottom = 20.dp, top = 20.dp))
            }
        }
    }
}

@Composable
fun Scrim(modifier: Modifier = Modifier) {
    Box(
        modifier
            .background(Brush.verticalGradient(listOf(Color.Transparent, Color.Black)))
            .height(180.dp)
            .fillMaxWidth())
}

@Composable
private fun Hint(text: String) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(horizontal = 24.dp, vertical = 32.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = text,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
            textAlign = TextAlign.Center
        )

    }
}

fun stringFrom(direction: Direction): String{
    return when (direction) {
        Direction.Left -> "👈 Left "
        Direction.Right -> "Right 👉"
        Direction.Up -> "Up 👆"
        Direction.Down -> "Down 👇"
        else -> ""
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewSwipeEffectCard(){
    SwipeEffectCardScreen(navHostController = rememberNavController())
}