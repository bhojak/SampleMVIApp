package com.bhojak.spacex.basicfeature

/*
     * Bhupendra Bhojak
*/

import com.bhojak.spacex.basicfeature.data.remote.model.RocketResponse
import com.bhojak.spacex.basicfeature.domain.model.Rocket
import java.time.LocalDate

internal fun generateTestRocketFromRemote() = RocketResponse(
    id = "1",
    name = "test rocket",
    costPerLaunch = 10_000_000,
    firstFlightDate = "2022-09-10",
    wikiUrl = "https://testrocket.com",
    imageUrls = listOf("https://testrocket.com/1.jpg"),
)

internal fun generateTestRocketFromDomain() = Rocket(
    id = "1",
    name = "test rocket",
    costPerLaunch = 10_000_000,
    firstFlight = LocalDate.parse("2022-09-10"),
    height = 20,
    weight = 30_000,
    wikiUrl = "https://testrocket.com",
    imageUrl = "https://testrocket.com/1.jpg",
)
