package br.applabbs.composecomponents.ui.theme.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class LiveViewModel(

): ViewModel() {

    private val _randomName = MutableLiveData("${Random.nextInt().toString()}")
    val randomName: LiveData<String> = _randomName

    private val _randomState = MutableLiveData<State>()
    val randomState: LiveData<State> = _randomState

    fun nextRandomInt(){
        viewModelScope.launch {
            delay(100)
            _randomName.value = Random.nextInt().toString()

            if(Random.nextBoolean()){
                _randomState.value = State(
                    state = Random.nextFloat().toString(),
                    content = Random.nextBoolean()
                )
            }else{
                _randomState.value = State(
                    state = "10F",
                    content = false
                )
            }
        }

    }

}

data class State(
    val state: String,
    val content: Boolean
)