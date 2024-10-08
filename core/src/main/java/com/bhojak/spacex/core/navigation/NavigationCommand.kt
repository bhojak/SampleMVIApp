package com.bhojak.spacex.core.navigation

/*
     * Bhupendra Bhojak
*/

import androidx.navigation.NavOptions

interface NavigationCommand {
    val destination: String
    val configuration: NavOptions
        get() = NavOptions.Builder().build()
}
