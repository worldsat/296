package com.uilover.project296.data.model

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class UserProfile(
    val id: String,
    val fullName: String,
    val displayName: String,
    val greeting: String,
    @DrawableRes val avatarResId: Int,
    val hasNotifications: Boolean
)

data class BankCard(
    val id: String,
    val balanceLabel: String,
    val balance: Double,
    val maskedNumber: String,
    val cardholderName: String,
    val expiry: String
)

enum class QuickActionType {
    ADD,
    SEND,
    PAY
}

data class QuickAction(
    val id: String,
    val type: QuickActionType,
    val label: String,
    val iconBackground: Color
)

data class TransferContact(
    val id: String,
    val name: String,
    @DrawableRes val avatarResId: Int
)

data class SpendingDay(
    val label: String,
    val amount: Double,
    val isHighlighted: Boolean
)

data class SpendingAnalytics(
    val totalSpent: Double,
    val percentChange: Int,
    val isDecrease: Boolean,
    val income: Double,
    val outcome: Double,
    val weeklySpending: List<SpendingDay>
)

data class DashboardUiState(
    val user: UserProfile,
    val card: BankCard,
    val quickActions: List<QuickAction>,
    val recentContacts: List<TransferContact>,
    val analytics: SpendingAnalytics,
    val selectedNavIndex: Int = 0
)
