package br.applabbs.composecomponents.ui.theme.bottomMenu

import androidx.annotation.DrawableRes
import br.applabbs.composecomponents.R

data class ItemBottomMenu(
    val itemTitle: String,
    @DrawableRes val itemIcon: Int
)

val itens = listOf<ItemBottomMenu>(
    ItemBottomMenu("Home", R.drawable.ic_home),
    ItemBottomMenu("Meditate", R.drawable.ic_bubble),
    ItemBottomMenu("Sleep", R.drawable.ic_moon),
    ItemBottomMenu("Music", R.drawable.ic_music),
    ItemBottomMenu("Profile", R.drawable.ic_profile),
)
