package br.applabbs.composecomponents.ui.theme.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class LiveViewModel: ViewModel() {

    private val _randomName = MutableLiveData("${Random.nextInt().toString()}")
    val randomName: LiveData<String> = _randomName


    fun nextRandomInt(){
        _randomName.value = Random.nextInt().toString()
    }

}