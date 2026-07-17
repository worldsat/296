package com.uilover.project296.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class VeloColors(
    val primary: Color = VeloPrimary,
    val primaryContainer: Color = VeloPrimaryContainer,
    val onPrimary: Color = VeloOnPrimary,
    val secondary: Color = VeloSecondary,
    val surface: Color = VeloSurface,
    val surfaceVariant: Color = VeloSurfaceVariant,
    val onSurface: Color = VeloOnSurface,
    val onSurfaceVariant: Color = VeloOnSurfaceVariant,
    val outline: Color = VeloOutline,
    val glow: Color = VeloGlow,
    val mutedText: Color = VeloMutedText,
    val chartInactive: Color = VeloChartInactive,
    val tealAction: Color = VeloTealAction,
    val percentBadge: Color = VeloPercentBadge
)

private val LocalVeloColors = staticCompositionLocalOf { VeloColors() }

private val VeloDarkColorScheme = darkColorScheme(
    primary = VeloPrimary,
    onPrimary = VeloOnPrimary,
    primaryContainer = VeloPrimaryContainer,
    onPrimaryContainer = VeloOnPrimary,
    secondary = VeloSecondary,
    onSecondary = VeloOnPrimary,
    background = VeloSurface,
    onBackground = VeloOnSurface,
    surface = VeloSurface,
    onSurface = VeloOnSurface,
    surfaceVariant = VeloSurfaceVariant,
    onSurfaceVariant = VeloMutedText,
    outline = VeloOutline
)

object VeloTheme {
    val colors: VeloColors
        @Composable
        get() = LocalVeloColors.current

    val typography
        @Composable
        get() = MaterialTheme.typography
}

@Composable
fun VeloTheme(content: @Composable () -> Unit) {
    CompositionLocalProvider(LocalVeloColors provides VeloColors()) {
        MaterialTheme(
            colorScheme = VeloDarkColorScheme,
            typography = VeloTypography,
            content = content
        )
    }
}

@Composable
fun Project296Theme(content: @Composable () -> Unit) {
    VeloTheme(content = content)
}
