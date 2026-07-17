package com.uilover.project296.data

import com.uilover.project296.R
import com.uilover.project296.data.model.BankCard
import com.uilover.project296.data.model.DashboardUiState
import com.uilover.project296.data.model.QuickAction
import com.uilover.project296.data.model.QuickActionType
import com.uilover.project296.data.model.SpendingAnalytics
import com.uilover.project296.data.model.SpendingDay
import com.uilover.project296.data.model.TransferContact
import com.uilover.project296.data.model.UserProfile
import com.uilover.project296.ui.theme.VeloPrimary
import com.uilover.project296.ui.theme.VeloSecondary
import com.uilover.project296.ui.theme.VeloTealAction

object MockData {

    val user = UserProfile(
        id = "user_jude",
        fullName = "Jude Doe",
        displayName = "Morning Jude",
        greeting = "Good morning,",
        avatarResId = R.drawable.profile,
        hasNotifications = true
    )

    val primaryCard = BankCard(
        id = "card_primary",
        balanceLabel = "Card Balance",
        balance = 4250.00,
        maskedNumber = "****  ****  ****  1234",
        cardholderName = "Jude Doe",
        expiry = "12/25"
    )

    val quickActions = listOf(
        QuickAction(
            id = "action_add",
            type = QuickActionType.ADD,
            label = "Add",
            iconBackground = VeloPrimary
        ),
        QuickAction(
            id = "action_send",
            type = QuickActionType.SEND,
            label = "Send",
            iconBackground = VeloSecondary
        ),
        QuickAction(
            id = "action_pay",
            type = QuickActionType.PAY,
            label = "Pay",
            iconBackground = VeloTealAction
        )
    )

    val recentContacts = listOf(
        TransferContact(
            id = "contact_sarah",
            name = "Sarah",
            avatarResId = R.drawable.sarah
        ),
        TransferContact(
            id = "contact_mike",
            name = "Mike",
            avatarResId = R.drawable.mike
        ),
        TransferContact(
            id = "contact_emma",
            name = "Emma",
            avatarResId = R.drawable.emma
        ),
        TransferContact(
            id = "contact_david",
            name = "David",
            avatarResId = R.drawable.devid
        )
    )

    val spendingAnalytics = SpendingAnalytics(
        totalSpent = 1245.50,
        percentChange = 12,
        isDecrease = true,
        income = 3450.00,
        outcome = 1245.50,
        weeklySpending = listOf(
            SpendingDay(label = "M", amount = 420.0, isHighlighted = false),
            SpendingDay(label = "T", amount = 680.0, isHighlighted = false),
            SpendingDay(label = "W", amount = 510.0, isHighlighted = false),
            SpendingDay(label = "T", amount = 920.0, isHighlighted = true),
            SpendingDay(label = "F", amount = 390.0, isHighlighted = false),
            SpendingDay(label = "S", amount = 470.0, isHighlighted = false),
            SpendingDay(label = "S", amount = 350.0, isHighlighted = false)
        )
    )

    val dashboardState = DashboardUiState(
        user = user,
        card = primaryCard,
        quickActions = quickActions,
        recentContacts = recentContacts,
        analytics = spendingAnalytics,
        selectedNavIndex = 0
    )
}
