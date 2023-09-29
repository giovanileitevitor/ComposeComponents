package br.applabbs.composecomponents.ui.theme.swipeEffect

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.applabbs.composecomponents.ui.theme.Green30
import br.applabbs.composecomponents.ui.theme.Green90
import com.alexstyl.swipeablecard.Direction
import com.alexstyl.swipeablecard.ExperimentalSwipeableCardApi
import com.alexstyl.swipeablecard.rememberSwipeableCardState
import com.alexstyl.swipeablecard.swipableCard

@OptIn(ExperimentalSwipeableCardApi::class)
@Composable
fun SwipeEffectCardScreen(navHostController: NavHostController){

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

        Box(

        ) {
            val states = cities.reversed().map {
                it to rememberSwipeableCardState()
            }

            var hint by remember {
                mutableStateOf("Swipe or press any button")
            }

            Hint(text = hint)

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

@Preview(showSystemUi = true)
@Composable
fun PreviewSwipeEffectCard(){
    SwipeEffectCardScreen(
        navHostController = rememberNavController()
    )
}