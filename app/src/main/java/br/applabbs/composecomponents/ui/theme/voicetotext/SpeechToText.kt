package br.applabbs.composecomponents.ui.theme.voicetotext

import kotlinx.coroutines.flow.StateFlow

interface SpeechToText {
    val text: StateFlow<String>
    fun start()
    fun stop()
}