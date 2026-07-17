package com.uilover.project296.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Apps
import androidx.compose.material.icons.outlined.CreditCard
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.QueryStats
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.uilover.project296.navigation.BottomNavDestination
import com.uilover.project296.ui.theme.VeloPrimary
import com.uilover.project296.ui.theme.VeloTheme

@Composable
fun VeloBottomNavBar(
    selectedIndex: Int,
    onItemSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val colors = VeloTheme.colors
    val icons = listOf(
        Icons.Outlined.Home,
        Icons.Outlined.QueryStats,
        Icons.Outlined.CreditCard,
        Icons.Outlined.Apps
    )

    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 28.dp)
            .shadow(
                elevation = 18.dp,
                shape = RoundedCornerShape(100.dp),
                ambientColor = VeloPrimary.copy(alpha = 0.35f),
                spotColor = VeloPrimary.copy(alpha = 0.35f)
            )
            .graphicsLayer {
                shape = RoundedCornerShape(100.dp)
                clip = true
                shadowElevation = 12f
            }
            .clip(RoundedCornerShape(100.dp))
            .background(colors.onSurfaceVariant.copy(alpha = 0.92f))
            .height(68.dp)
            .padding(horizontal = 18.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BottomNavDestination.entries.forEachIndexed { index, destination ->
                BottomNavItem(
                    icon = icons[index],
                    label = destination.label,
                    selected = selectedIndex == index,
                    onClick = { onItemSelected(index) }
                )
            }
        }
    }
}

@Composable
private fun BottomNavItem(
    icon: ImageVector,
    label: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    val colors = VeloTheme.colors

    Box(
        modifier = Modifier
            .size(48.dp)
            .then(
                if (selected) {
                    Modifier.shadow(
                        elevation = 12.dp,
                        shape = CircleShape,
                        ambientColor = VeloPrimary.copy(alpha = 0.4f),
                        spotColor = VeloPrimary.copy(alpha = 0.4f)
                    )
                } else {
                    Modifier
                }
            )
            .clip(CircleShape)
            .background(
                if (selected) colors.primary else androidx.compose.ui.graphics.Color.Transparent
            )
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = if (selected) colors.onPrimary else colors.mutedText,
            modifier = Modifier.size(22.dp)
        )
    }
}
