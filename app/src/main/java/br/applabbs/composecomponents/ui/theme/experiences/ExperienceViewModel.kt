package br.applabbs.composecomponents.ui.theme.experiences

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.random.Random

class ExperienceViewModel: ViewModel() {

    private val _color = MutableStateFlow(0xFFFFFFFF)
    val color = _color.asStateFlow()

    var composeColor by mutableStateOf(0xFFFFFFFF)
        private set

    fun generateNewColor(){
        val color = Random.nextLong(0xFFFFFFFF)
        _color.value = color
        composeColor = color
    }
}