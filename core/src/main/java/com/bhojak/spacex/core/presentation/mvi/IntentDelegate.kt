package com.bhojak.spacex.core.presentation.mvi

/*
     * Bhupendra Bhojak
*/

import kotlinx.coroutines.flow.Flow

interface IntentDelegate<INTENT, PARTIAL_UI_STATE> {
    fun getIntents(mapOperation: (INTENT) -> Flow<PARTIAL_UI_STATE>): Flow<PARTIAL_UI_STATE>

    suspend fun setIntent(intent: INTENT)
}
