package br.applabbs.composecomponents.ui.theme.instagramNews

import androidx.annotation.DrawableRes
import br.applabbs.composecomponents.R

sealed class UiState{
    object Loading: UiState()
    object Error: UiState()
    object Success: UiState()
}


data class InstagramCard(
    val cardName: String,
    @DrawableRes val cardImage: Int
)

data class InstagramCardInternet(
    val cardName: String,
    val cardImageUrl: String
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

val cardsInternet = listOf(
    InstagramCardInternet("Berlim", "https://source.unsplash.com/random/200x200?sig=1"),
    InstagramCardInternet("Roma", "https://source.unsplash.com/random/200x200?sig=2"),
    InstagramCardInternet("Manaus", "https://source.unsplash.com/random/200x200?sig=3"),
    InstagramCardInternet("São Paulo", "https://source.unsplash.com/random/200x200?sig=4"),
    InstagramCardInternet("Juazeiro", "https://source.unsplash.com/random/200x200?sig=5"),
    InstagramCardInternet("Nova York", "https://source.unsplash.com/random/200x200?sig=6"),
    InstagramCardInternet("Londres", "https://source.unsplash.com/random/200x200?sig=7"),
)
