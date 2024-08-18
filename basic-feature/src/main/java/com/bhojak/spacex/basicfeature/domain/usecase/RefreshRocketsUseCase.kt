package com.bhojak.spacex.basicfeature.domain.usecase

/*
     * Bhupendra Bhojak
*/

import com.bhojak.spacex.basicfeature.domain.repository.RocketRepository
import com.bhojak.spacex.core.utils.resultOf

fun interface RefreshRocketsUseCase : suspend () -> Result<Unit>

suspend fun refreshRockets(rocketRepository: RocketRepository): Result<Unit> = resultOf {
    rocketRepository.refreshRockets()
}
