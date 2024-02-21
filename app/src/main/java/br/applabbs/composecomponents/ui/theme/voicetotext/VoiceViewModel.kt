package br.applabbs.composecomponents.ui.theme.voicetotext

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.core.app.PendingIntentCompat.send
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class VoiceViewModel(
    private val stt: SpeechToText
): ViewModel() {

    var state by mutableStateOf(AppState())
        private set

    init {
        viewModelScope.launch {
            with(stt) {
                text.collect { result ->
                    send(AppAction.Update(result))
                }
            }
        }
    }

    fun send(action: AppAction) {
        when (action) {
            AppAction.StartRecord -> {
                stt.start()
            }

            AppAction.EndRecord -> {
                stt.stop()
                viewModelScope.launch {
                    delay(3000)
                    state = state.copy(
                        display = ""
                    )
                }
            }
            is AppAction.Update -> {
                state = state.copy(
                    display = state.display + action.text
                )
            }
        }
    }
}
