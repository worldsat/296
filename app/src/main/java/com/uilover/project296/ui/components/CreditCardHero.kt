package com.uilover.project296.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Wifi
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uilover.project296.data.model.BankCard
import com.uilover.project296.ui.theme.VeloPrimary
import com.uilover.project296.ui.theme.VeloSecondary
import com.uilover.project296.ui.theme.VeloTheme

@Composable
fun CreditCardHero(
    card: BankCard,
    formattedBalance: String,
    modifier: Modifier = Modifier
) {
    val colors = VeloTheme.colors
    val shape = RoundedCornerShape(24.dp)

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(196.dp)
            .clip(shape)
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(VeloPrimary, VeloSecondary),
                    start = Offset.Zero,
                    end = Offset(900f, 900f)
                )
            )
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val center = Offset(size.width * 0.92f, size.height * 0.55f)
            val stroke = Stroke(width = 1.5.dp.toPx())
            val ringColor = Color.White.copy(alpha = 0.18f)
            for (index in 1..5) {
                drawCircle(
                    color = ringColor,
                    radius = size.minDimension * (0.18f + index * 0.14f),
                    center = center,
                    style = stroke
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 22.dp, vertical = 20.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = card.balanceLabel,
                    style = VeloTheme.typography.bodyMedium,
                    color = Color.White.copy(alpha = 0.85f)
                )
                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .clip(CircleShape)
                        .background(Color.White.copy(alpha = 0.18f)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Filled.Wifi,
                        contentDescription = "Contactless",
                        tint = Color.White,
                        modifier = Modifier
                            .size(18.dp)
                            .align(Alignment.Center)
                    )
                }
            }

            Text(
                text = formattedBalance,
                color = colors.onPrimary,
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = (-0.5).sp
            )

            Spacer(modifier = Modifier.height(4.dp))

            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Text(
                    text = card.maskedNumber,
                    color = Color.White.copy(alpha = 0.92f),
                    style = VeloTheme.typography.bodyLarge,
                    letterSpacing = 1.5.sp
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = card.cardholderName,
                        color = Color.White.copy(alpha = 0.92f),
                        style = VeloTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Medium
                    )
                    Text(
                        text = card.expiry,
                        color = Color.White.copy(alpha = 0.92f),
                        style = VeloTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    }
}
