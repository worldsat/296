package com.uilover.project296

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MainViewModel : ViewModel() {

    private val _hasCompletedIntro = MutableStateFlow(false)
    val hasCompletedIntro: StateFlow<Boolean> = _hasCompletedIntro.asStateFlow()

    fun onIntroCompleted() {
        _hasCompletedIntro.update { true }
    }
}
