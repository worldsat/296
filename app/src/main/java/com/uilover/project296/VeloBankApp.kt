package com.uilover.project296

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.uilover.project296.navigation.VeloBankNavHost
import com.uilover.project296.ui.intro.IntroRoute
import com.uilover.project296.ui.theme.VeloTheme

@Composable
fun VeloBankApp(
    mainViewModel: MainViewModel = viewModel()
) {
    val hasCompletedIntro by mainViewModel.hasCompletedIntro.collectAsStateWithLifecycle()
    val navController = rememberNavController()

    VeloTheme {
        if (hasCompletedIntro) {
            VeloBankNavHost(navController = navController)
        } else {
            IntroRoute(onNavigateToHome = mainViewModel::onIntroCompleted)
        }
    }
}
