package com.uilover.project296.ui.intro

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.uilover.project296.R
import com.uilover.project296.ui.components.VeloGradientButton
import com.uilover.project296.ui.theme.VeloTheme

@Composable
fun IntroRoute(
    onNavigateToHome: () -> Unit,
    viewModel: IntroViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    IntroScreen(
        uiState = uiState,
        onJoinClick = onNavigateToHome
    )
}

@Composable
fun IntroScreen(
    uiState: IntroUiState,
    onJoinClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val colors = VeloTheme.colors
    var contentVisible by remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()

    LaunchedEffect(Unit) {
        contentVisible = true
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black)
            .statusBarsPadding()
            .navigationBarsPadding()
            .padding(horizontal = 20.dp)
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            AnimatedVisibility(
                visible = contentVisible,
                enter = fadeIn() + slideInVertically { -it / 4 }
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Spacer(modifier = Modifier.height(24.dp))

                    Image(
                        painter = painterResource(id = R.drawable.intro_cart),
                        contentDescription = "VeloBank card stack",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp)
                    )
                }
            }

            AnimatedVisibility(
                visible = contentVisible,
                enter = fadeIn() + slideInVertically { it / 3 }
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                    Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                        Text(
                            text = uiState.headlineLineOne,
                            style = VeloTheme.typography.displayMedium,
                            color = colors.onSurface,
                            fontWeight = FontWeight.SemiBold
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = uiState.headlineLineTwo,
                            style = VeloTheme.typography.displayMedium,
                            color = colors.onSurface,
                            fontWeight = FontWeight.SemiBold
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = uiState.headlineLineThree,
                            style = VeloTheme.typography.displayMedium,
                            color = colors.onSurface,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = uiState.description,
                        style = VeloTheme.typography.bodyLarge,
                        color = colors.mutedText,
                        lineHeight = VeloTheme.typography.bodyLarge.lineHeight
                    )

                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }

        VeloGradientButton(
            text = uiState.ctaLabel,
            onClick = onJoinClick,
            modifier = Modifier.padding(bottom = 24.dp)
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF000000, widthDp = 390, heightDp = 844)
@Composable
private fun IntroScreenPreview() {
    VeloTheme {
        IntroScreen(
            uiState = IntroUiState(),
            onJoinClick = {}
        )
    }
}
