package com.uilover.project296.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.uilover.project296.ui.home.HomeRoute
import com.uilover.project296.ui.screens.SecondaryTabScreen

@Composable
fun VeloBankNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Home,
        modifier = modifier.fillMaxSize()
    ) {
        composable<Home> {
            HomeRoute(
                onNavigateToTab = { index ->
                    navigateToBottomDestination(navController, index)
                }
            )
        }

        composable<Analytics> {
            SecondaryTabScreen(
                title = "Analytics",
                selectedNavIndex = BottomNavDestination.ANALYTICS.ordinal,
                onNavSelected = { index ->
                    navigateToBottomDestination(navController, index)
                }
            )
        }

        composable<Cards> {
            SecondaryTabScreen(
                title = "Cards",
                selectedNavIndex = BottomNavDestination.CARDS.ordinal,
                onNavSelected = { index ->
                    navigateToBottomDestination(navController, index)
                }
            )
        }

        composable<Settings> {
            SecondaryTabScreen(
                title = "Settings",
                selectedNavIndex = BottomNavDestination.SETTINGS.ordinal,
                onNavSelected = { index ->
                    navigateToBottomDestination(navController, index)
                }
            )
        }


    }
}

private fun navigateToBottomDestination(
    navController: NavHostController,
    index: Int
) {
    val destination = when (index) {
        BottomNavDestination.HOME.ordinal -> Home
        BottomNavDestination.ANALYTICS.ordinal -> Analytics
        BottomNavDestination.CARDS.ordinal -> Cards
        BottomNavDestination.SETTINGS.ordinal -> Settings
        else -> Home
    }

    navController.navigate(destination) {
        popUpTo(Home) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}
