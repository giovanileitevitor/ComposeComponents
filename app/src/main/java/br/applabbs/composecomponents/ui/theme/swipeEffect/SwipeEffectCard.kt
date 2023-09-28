package br.applabbs.composecomponents.ui.theme.swipeEffect

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.applabbs.composecomponents.R
import com.alexstyl.swipeablecard.ExperimentalSwipeableCardApi
import com.alexstyl.swipeablecard.rememberSwipeableCardState
import com.alexstyl.swipeablecard.swipableCard

@OptIn(ExperimentalSwipeableCardApi::class)
@Composable
fun SwipeEffectCard(navHostController: NavHostController){

    val context = LocalContext.current
    val state = rememberSwipeableCardState()

    Row(
        modifier = Modifier
            .padding(20.dp)
            .graphicsLayer {  }
            .background(Color.White)
            .swipableCard(
                state = state,
                onSwiped = { direction ->
                    Toast.makeText(context, "Card moved to :$direction", Toast.LENGTH_SHORT).show()
                },
                onSwipeCancel = {
                    val a = 10
                }
            )
    ){
        SingleCard(
            title = "City Name",
            image = R.drawable.ic_city_1,
            modifier = Modifier
        )

    }
}

@Preview
@Composable
fun PreviewSwipeEffectCard(){
    SwipeEffectCard(navHostController = rememberNavController())
}