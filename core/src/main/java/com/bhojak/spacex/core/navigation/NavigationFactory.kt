package com.bhojak.spacex.core.navigation

/*
     * Bhupendra Bhojak
*/

import androidx.navigation.NavGraphBuilder

interface NavigationFactory {
    fun create(builder: NavGraphBuilder)
}
