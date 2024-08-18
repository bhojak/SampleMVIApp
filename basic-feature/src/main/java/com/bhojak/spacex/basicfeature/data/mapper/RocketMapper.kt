package com.bhojak.spacex.basicfeature.data.mapper

/*
     * Bhupendra Bhojak
*/

import com.bhojak.spacex.basicfeature.data.local.model.RocketCached
import com.bhojak.spacex.basicfeature.data.remote.model.RocketResponse
import com.bhojak.spacex.basicfeature.domain.model.Rocket
import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun RocketResponse.toDomainModel() = Rocket(
    id = id,
    name = name,
    costPerLaunch = costPerLaunch,
    firstFlight = LocalDate.parse(firstFlightDate),
    height = height.meters.toInt(),
    weight = weight.kg,
    wikiUrl = wikiUrl,
    imageUrl = imageUrls.random(),
)

fun RocketCached.toDomainModel() = Rocket(
    id = id,
    name = name,
    costPerLaunch = costPerLaunch,
    firstFlight = LocalDate.parse(firstFlightDate),
    height = height,
    weight = weight,
    wikiUrl = wikiUrl,
    imageUrl = imageUrl,
)

fun Rocket.toEntityModel() = RocketCached(
    id = id,
    name = name,
    costPerLaunch = costPerLaunch,
    firstFlightDate = firstFlight.format(DateTimeFormatter.ISO_LOCAL_DATE),
    height = height,
    weight = weight,
    wikiUrl = wikiUrl,
    imageUrl = imageUrl,
)
