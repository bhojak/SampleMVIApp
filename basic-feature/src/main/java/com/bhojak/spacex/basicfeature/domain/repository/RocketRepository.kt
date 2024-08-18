package com.bhojak.spacex.basicfeature.domain.repository

/*
     * Bhupendra Bhojak
*/

import com.bhojak.spacex.basicfeature.domain.model.Rocket
import kotlinx.coroutines.flow.Flow

interface RocketRepository {
    fun getRockets(): Flow<List<Rocket>>

    suspend fun refreshRockets()
}
