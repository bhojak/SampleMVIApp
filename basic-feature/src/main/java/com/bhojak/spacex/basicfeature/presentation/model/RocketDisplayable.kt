package com.bhojak.spacex.basicfeature.presentation.model

/*
     * Bhupendra Bhojak
*/

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RocketDisplayable(
    val id: String,
    val name: String,
    val costPerLaunchInMillions: Int,
    val firstFlightDate: String,
    val heightInMeters: Int,
    val weightInTonnes: Int,
    val wikiUrl: String,
    val imageUrl: String,
) : Parcelable
