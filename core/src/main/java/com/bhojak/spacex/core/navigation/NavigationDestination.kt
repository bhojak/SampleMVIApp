package com.bhojak.spacex.core.navigation

/*
     * Bhupendra Bhojak
*/

sealed class NavigationDestination(
    val route: String,
) {
    data object Rockets : NavigationDestination("rocketsDestination")

    data object Back : NavigationDestination("navigationBack")
}
