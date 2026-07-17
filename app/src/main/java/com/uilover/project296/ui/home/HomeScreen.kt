package com.uilover.project296.ui.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.uilover.project296.data.model.DashboardUiState
import com.uilover.project296.data.model.QuickAction
import com.uilover.project296.data.model.TransferContact
import com.uilover.project296.ui.components.CreditCardHero
import com.uilover.project296.ui.components.HomeHeader
import com.uilover.project296.ui.components.QuickActionsRow
import com.uilover.project296.ui.components.SendAgainSection
import com.uilover.project296.ui.components.SpendingAnalyticsCard
import com.uilover.project296.ui.components.VeloBottomNavBar
import com.uilover.project296.ui.theme.VeloTheme

@Composable
fun HomeRoute(
    onNavigateToTab: (Int) -> Unit,
    viewModel: HomeViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.onNavSelected(0)
    }

    HomeScreen(
        uiState = uiState,
        formatCurrency = viewModel::formatCurrency,
        onNotificationClick = {},
        onQuickActionClick = {},
        onSearchClick = {},
        onContactClick = {},
        onViewAllClick = {},
        onNavSelected = { index ->
            viewModel.onNavSelected(index)
            onNavigateToTab(index)
        }
    )
}

@Composable
fun HomeScreen(
    uiState: DashboardUiState,
    formatCurrency: (Double) -> String,
    onNotificationClick: () -> Unit,
    onQuickActionClick: (QuickAction) -> Unit,
    onSearchClick: () -> Unit,
    onContactClick: (TransferContact) -> Unit,
    onViewAllClick: () -> Unit,
    onNavSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val colors = VeloTheme.colors
    var sectionsVisible by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        sectionsVisible = true
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(colors.surface)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp)
                .padding(top = 12.dp, bottom = 120.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            AnimatedVisibility(
                visible = sectionsVisible,
                enter = fadeIn() + slideInVertically { it / 6 }
            ) {
                HomeHeader(
                    user = uiState.user,
                    onNotificationClick = onNotificationClick
                )
            }

            AnimatedVisibility(
                visible = sectionsVisible,
                enter = fadeIn() + slideInVertically { it / 5 }
            ) {
                CreditCardHero(
                    card = uiState.card,
                    formattedBalance = formatCurrency(uiState.card.balance)
                )
            }

            AnimatedVisibility(
                visible = sectionsVisible,
                enter = fadeIn() + slideInVertically { it / 4 }
            ) {
                QuickActionsRow(
                    actions = uiState.quickActions,
                    onActionClick = onQuickActionClick
                )
            }

            AnimatedVisibility(
                visible = sectionsVisible,
                enter = fadeIn() + slideInVertically { it / 3 }
            ) {
                SendAgainSection(
                    contacts = uiState.recentContacts,
                    onSearchClick = onSearchClick,
                    onContactClick = onContactClick,
                    onViewAllClick = onViewAllClick
                )
            }

            AnimatedVisibility(
                visible = sectionsVisible,
                enter = fadeIn() + slideInVertically { it / 2 }
            ) {
                SpendingAnalyticsCard(
                    analytics = uiState.analytics,
                    formattedTotalSpent = formatCurrency(uiState.analytics.totalSpent),
                    formattedIncome = formatCurrency(uiState.analytics.income),
                    formattedOutcome = formatCurrency(uiState.analytics.outcome)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))
        }

        VeloBottomNavBar(
            selectedIndex = uiState.selectedNavIndex,
            onItemSelected = onNavSelected,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .navigationBarsPadding()
                .padding(bottom = 16.dp)
                .fillMaxWidth()
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF131313, widthDp = 390, heightDp = 844)
@Composable
private fun HomeScreenPreview() {
    VeloTheme {
        val viewModel = HomeViewModel()
        val uiState = viewModel.uiState.value
        HomeScreen(
            uiState = uiState,
            formatCurrency = viewModel::formatCurrency,
            onNotificationClick = {},
            onQuickActionClick = {},
            onSearchClick = {},
            onContactClick = {},
            onViewAllClick = {},
            onNavSelected = {}
        )
    }
}
