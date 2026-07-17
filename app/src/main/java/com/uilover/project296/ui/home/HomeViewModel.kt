package com.uilover.project296.ui.home

import androidx.lifecycle.ViewModel
import com.uilover.project296.data.MockData
import com.uilover.project296.data.model.DashboardUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.text.NumberFormat
import java.util.Locale

class HomeViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(MockData.dashboardState)
    val uiState: StateFlow<DashboardUiState> = _uiState.asStateFlow()

    fun onNavSelected(index: Int) {
        _uiState.update { current ->
            current.copy(selectedNavIndex = index.coerceIn(0, 3))
        }
    }

    fun formatCurrency(amount: Double): String {
        val formatter = NumberFormat.getCurrencyInstance(Locale.US)
        return formatter.format(amount)
    }
}
