package com.uilover.project296.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.uilover.project296.ui.theme.VeloPrimary
import com.uilover.project296.ui.theme.VeloSecondary
import com.uilover.project296.ui.theme.VeloTheme

@Composable
fun VeloGradientButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val colors = VeloTheme.colors
    val shape = RoundedCornerShape(100.dp)

    Surface(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp),
        shape = shape,
        color = Color.Transparent
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(VeloPrimary, VeloSecondary)
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                style = VeloTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                color = colors.onPrimary
            )
        }
    }
}
