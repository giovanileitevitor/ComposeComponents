package br.applabbs.composecomponents.ui.theme.swipeEffect

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Scrim(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .height(180.dp)
            .fillMaxWidth()
            .background(
                brush = Brush.verticalGradient(
                    listOf(Color.Transparent, Color.Black))
            ))

}