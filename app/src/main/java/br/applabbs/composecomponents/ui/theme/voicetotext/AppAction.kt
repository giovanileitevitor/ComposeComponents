package br.applabbs.composecomponents.ui.theme.voicetotext

sealed class AppAction {
    object StartRecord : AppAction()
    object EndRecord : AppAction()
    data class Update(val text: String): AppAction()
}