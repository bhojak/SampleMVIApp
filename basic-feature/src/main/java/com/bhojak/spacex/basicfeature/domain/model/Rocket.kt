package com.bhojak.spacex.basicfeature.domain.model

/*
     * Bhupendra Bhojak
*/

import java.time.LocalDate

data class Rocket(
    val id: String,
    val name: String,
    val costPerLaunch: Int,
    val firstFlight: LocalDate,
    val height: Int,
    val weight: Int,
    val wikiUrl: String,
    val imageUrl: String,
)
