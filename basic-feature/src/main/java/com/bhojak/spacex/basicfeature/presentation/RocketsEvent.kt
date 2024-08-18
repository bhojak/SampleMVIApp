package com.bhojak.spacex.basicfeature.presentation

/*
     * Bhupendra Bhojak
*/

sealed class RocketsEvent {
    data class OpenWebBrowserWithDetails(val uri: String) : RocketsEvent()
}
