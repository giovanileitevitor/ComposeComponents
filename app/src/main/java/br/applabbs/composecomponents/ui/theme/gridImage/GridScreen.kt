package br.applabbs.composecomponents.ui.theme.gridImage

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.MagnifierStyle
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.magnifier
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.applabbs.composecomponents.R
import kotlin.random.Random

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GridScreen(navHostController: NavHostController) {

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        var offset by remember { mutableStateOf(Offset.Zero) }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .pointerInput(Unit) {
                    detectDragGestures { change, _ ->
                        offset = change.position
                    }
                }
                .magnifier(
                    sourceCenter = {
                        offset - Offset(x = 50f, y = 50f)
                    },
                    zoom = 2F,
                    magnifierCenter = {
                        offset- Offset(x = 50f, y = 50f)
                    },
                    style = MagnifierStyle(
                        size = DpSize(100.dp, 100.dp),
                        cornerRadius = 100.dp
                    )
                )
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_city_2),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(2.dp)
                    .clip(shape = MaterialTheme.shapes.medium),
                contentScale = ContentScale.FillWidth
            )
        }
    }
}

@Composable
fun randomColor(): Color {
    val random = Random
    return Color(
        red = random.nextFloat(),
        green = random.nextFloat(),
        blue = random.nextFloat(),
        alpha = 1f
    )
}

@Composable
private fun getScreenSize(): Pair<Int, Int> {
    val displayMetrics = LocalContext.current.resources.displayMetrics
    val width = displayMetrics.widthPixels
    val height = displayMetrics.heightPixels
    return Pair(width, height)
}

@Preview(showBackground = true)
@Composable
fun PreviewGridScreen(){
    GridScreen(navHostController = rememberNavController())
}
/*
    val minWidth = 100.dp

//    Column(modifier = Modifier.fillMaxWidth()) {
//        for (i in 0 until 20) {
//            Row(modifier = Modifier.fillMaxWidth()) {
//                for (j in 0 until 10) {
//                    Card(
//                        modifier = Modifier
//                            .padding(8.dp)
//                            .size(
//                                width = (100.dp * (maxWidth / 1000.dp)).coerceAtLeast(minWidth),
//                                height = minHeight
//                            ),
//                        shape = RoundedCornerShape(8.dp),
//                        elevation = 4.dp
//                    ) {
//                        Text(
//                            text = "Cell ${i}-${j}",
//                            style = MaterialTheme.typography.body1,
//                            color = Color.White
//                        )
//                    }
//                }
//            }
//        }
//    }
 */