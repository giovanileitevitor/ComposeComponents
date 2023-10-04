package br.applabbs.composecomponents.ui.theme.instagramNews

import androidx.annotation.DrawableRes
import br.applabbs.composecomponents.R


data class InstagramCard(
    val cardName: String,
    @DrawableRes val cardImage: Int
)

val cards = listOf(
    InstagramCard("Berlim", R.drawable.ic_city_1),
    InstagramCard("New York", R.drawable.ic_city_2),
    InstagramCard("Adelaide", R.drawable.ic_city_3),
    InstagramCard("Londres", R.drawable.ic_city_4),
    InstagramCard("São Paulo", R.drawable.ic_city_1),
    InstagramCard("Roma", R.drawable.ic_city_2),
    InstagramCard("Rio de Janeiro de 2023", R.drawable.ic_city_3),
    InstagramCard("Washington", R.drawable.ic_city_4),
    InstagramCard("Adelaide", R.drawable.ic_city_3),
    InstagramCard("Londres", R.drawable.ic_city_4),
    InstagramCard("São Paulo", R.drawable.ic_city_1),
    InstagramCard("Roma", R.drawable.ic_city_2),
)
