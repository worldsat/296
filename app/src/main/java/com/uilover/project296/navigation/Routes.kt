package com.uilover.project296.navigation

import kotlinx.serialization.Serializable

@Serializable
object Intro

@Serializable
object Home

@Serializable
object Analytics

@Serializable
object Cards

@Serializable
object Settings

@Serializable
data class ProductDetails(val productId: String)

enum class BottomNavDestination(
    val label: String,
    val route: Any
) {
    HOME("Home", Home),
    ANALYTICS("Analytics", Analytics),
    CARDS("Cards", Cards),
    SETTINGS("Settings", Settings)
}
