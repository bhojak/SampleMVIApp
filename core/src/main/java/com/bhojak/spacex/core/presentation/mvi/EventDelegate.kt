package com.bhojak.spacex.core.presentation.mvi

/*
     * Bhupendra Bhojak
*/

import kotlinx.coroutines.flow.Flow

interface EventDelegate<EVENT> {
    fun getEvents(): Flow<EVENT>

    suspend fun setEvent(event: EVENT)
}
