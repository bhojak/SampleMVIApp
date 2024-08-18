package com.bhojak.spacex.basicfeature.presentation

/*
     * Bhupendra Bhojak
*/

sealed class RocketsIntent {
    data object RefreshRockets : RocketsIntent()

    data class RocketClicked(val uri: String) : RocketsIntent()
}
