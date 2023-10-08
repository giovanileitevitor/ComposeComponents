package br.applabbs.composecomponents.ui.theme.bottomMenu

import androidx.annotation.DrawableRes
import br.applabbs.composecomponents.R

data class ItemBottomMenu(
    val itemTitle: String,
    @DrawableRes val itemIcon: Int
)

val itens = listOf<ItemBottomMenu>(
    ItemBottomMenu("Início", R.drawable.ic_home),
    ItemBottomMenu("Minha rede", R.drawable.ic_network),
    ItemBottomMenu("Publicar", R.drawable.ic_publicar),
    ItemBottomMenu("Notificações", R.drawable.ic_notificar),
    ItemBottomMenu("Vagas", R.drawable.ic_vagas),
)
