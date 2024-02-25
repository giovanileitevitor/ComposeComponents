package br.applabbs.composecomponents.ui.theme.home

import androidx.lifecycle.LifecycleOwner

interface AnalyticsLogger {
    fun registerLifeCycleOwner(owner: LifecycleOwner)
}