package br.applabbs.composecomponents.ui.theme.swipeEffect

import androidx.annotation.DrawableRes
import br.applabbs.composecomponents.R

data class MatchCity(
    val cityName: String,
    @DrawableRes val cityImage: Int
)

val cities = listOf<MatchCity>(
    MatchCity("Berlim", R.drawable.ic_city_1),
    MatchCity("New York", R.drawable.ic_city_2),
    MatchCity("Adelaide", R.drawable.ic_city_3),
    MatchCity("Londres", R.drawable.ic_city_4),
)
