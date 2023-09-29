package br.applabbs.composecomponents.ui.theme.swipeEffect

import com.alexstyl.swipeablecard.Direction


fun stringFrom(direction: Direction): String{
    return when (direction) {
        Direction.Left -> "👈 Left "
        Direction.Right -> "Right 👉"
        Direction.Up -> "Up 👆"
        Direction.Down -> "Down 👇"
        else -> ""
    }
}