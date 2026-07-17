package com.uilover.project296.ui.intro

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class IntroUiState(
    val headlineLineOne: String = "Effortless",
    val headlineLineTwo: String = "Bank",
    val headlineLineThree: String = "Simplified",
    val description: String =
        "Experience seamless financial \nmanagement makes managing your \nfinances easy and intuitive",
    val ctaLabel: String = "Join Velobank Now"
)

class IntroViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(IntroUiState())
    val uiState: StateFlow<IntroUiState> = _uiState.asStateFlow()
}
