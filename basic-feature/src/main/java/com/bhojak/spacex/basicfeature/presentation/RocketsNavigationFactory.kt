package com.bhojak.spacex.basicfeature.presentation

/*
     * Bhupendra Bhojak
*/

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.bhojak.spacex.basicfeature.presentation.composable.RocketsRoute
import com.bhojak.spacex.core.navigation.NavigationDestination.Rockets
import com.bhojak.spacex.core.navigation.NavigationFactory
import javax.inject.Inject

class RocketsNavigationFactory @Inject constructor() : NavigationFactory {

    override fun create(builder: NavGraphBuilder) {
        builder.composable(Rockets.route) {
            RocketsRoute()
        }
    }
}
