package com.uilover.project296.ui.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uilover.project296.data.model.SpendingAnalytics
import com.uilover.project296.ui.theme.VeloPrimary
import com.uilover.project296.ui.theme.VeloSecondary
import com.uilover.project296.ui.theme.VeloTheme

@Composable
fun SpendingAnalyticsCard(
    analytics: SpendingAnalytics,
    formattedTotalSpent: String,
    formattedIncome: String,
    formattedOutcome: String,
    modifier: Modifier = Modifier
) {
    val colors = VeloTheme.colors

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(24.dp))
            .background(colors.surfaceVariant)
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Text(
                    text = "Total Spent",
                    style = VeloTheme.typography.bodyMedium,
                    color = colors.mutedText
                )
                Text(
                    text = formattedTotalSpent,
                    color = colors.onSurface,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(100.dp))
                    .background(colors.percentBadge)
                    .padding(horizontal = 10.dp, vertical = 6.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                if (analytics.isDecrease) {
                    Icon(
                        imageVector = Icons.Filled.ArrowDownward,
                        contentDescription = null,
                        tint = colors.primary,
                        modifier = Modifier.size(14.dp)
                    )
                }
                Text(
                    text = "${analytics.percentChange}%",
                    style = VeloTheme.typography.labelLarge,
                    color = colors.primary,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }

        WeeklySpendingChart(weeklySpending = analytics.weeklySpending)

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            MiniStatCard(
                label = "Income",
                value = formattedIncome,
                dotColor = VeloPrimary,
                modifier = Modifier.weight(1f)
            )
            MiniStatCard(
                label = "Outcome",
                value = formattedOutcome,
                dotColor = VeloSecondary.copy(alpha = 0.85f),
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
private fun WeeklySpendingChart(
    weeklySpending: List<com.uilover.project296.data.model.SpendingDay>
) {
    val colors = VeloTheme.colors
    val maxAmount = weeklySpending.maxOfOrNull { it.amount }?.takeIf { it > 0.0 } ?: 1.0

    val infiniteTransition = rememberInfiniteTransition(label = "chartGlow")
    val glowAlpha by infiniteTransition.animateFloat(
        initialValue = 0.28f,
        targetValue = 0.55f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1400, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "glowAlpha"
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(140.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom
    ) {
        weeklySpending.forEach { day ->
            val normalizedHeight = (day.amount / maxAmount).toFloat().coerceIn(0.18f, 1f)

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.weight(1f)
            ) {
                Box(
                    modifier = Modifier
                        .height(110.dp)
                        .width(12.dp),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(normalizedHeight)
                            .then(
                                if (day.isHighlighted) {
                                    Modifier.shadow(
                                        elevation = 10.dp,
                                        shape = RoundedCornerShape(100.dp),
                                        ambientColor = VeloPrimary.copy(alpha = glowAlpha),
                                        spotColor = VeloPrimary.copy(alpha = glowAlpha)
                                    )
                                } else {
                                    Modifier
                                }
                            )
                            .clip(RoundedCornerShape(100.dp))
                            .background(
                                if (day.isHighlighted) VeloPrimary else colors.chartInactive
                            )
                    )
                }
                Text(
                    text = day.label,
                    style = VeloTheme.typography.labelSmall,
                    color = colors.mutedText
                )
            }
        }
    }
}

@Composable
private fun MiniStatCard(
    label: String,
    value: String,
    dotColor: Color,
    modifier: Modifier = Modifier
) {
    val colors = VeloTheme.colors

    Column(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFF141414))
            .padding(horizontal = 14.dp, vertical = 14.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(8.dp)
                    .clip(CircleShape)
                    .background(dotColor)
            )
            Text(
                text = label,
                style = VeloTheme.typography.labelSmall,
                color = colors.mutedText
            )
        }
        Text(
            text = value,
            style = VeloTheme.typography.titleMedium.copy(fontWeight = FontWeight.SemiBold),
            color = colors.onSurface
        )
    }
}
