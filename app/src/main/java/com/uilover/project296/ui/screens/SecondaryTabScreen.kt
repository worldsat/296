package com.uilover.project296.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.uilover.project296.ui.components.VeloBottomNavBar
import com.uilover.project296.ui.theme.VeloTheme

@Composable
fun SecondaryTabScreen(
    title: String,
    selectedNavIndex: Int,
    onNavSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val colors = VeloTheme.colors

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(colors.surface)
            .statusBarsPadding()
    ) {
        Text(
            text = title,
            style = VeloTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
            color = colors.onSurface,
            modifier = Modifier.align(Alignment.Center)
        )

        VeloBottomNavBar(
            selectedIndex = selectedNavIndex,
            onItemSelected = onNavSelected,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .navigationBarsPadding()
                .padding(bottom = 16.dp)
        )
    }
}
