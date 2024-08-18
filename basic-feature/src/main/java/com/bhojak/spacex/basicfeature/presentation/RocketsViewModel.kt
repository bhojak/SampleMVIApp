package com.bhojak.spacex.basicfeature.presentation

/*
     * Bhupendra Bhojak
*/

import androidx.lifecycle.SavedStateHandle
import dagger.hilt.android.lifecycle.HiltViewModel
import com.bhojak.spacex.basicfeature.domain.usecase.GetRocketsUseCase
import com.bhojak.spacex.basicfeature.domain.usecase.RefreshRocketsUseCase
import com.bhojak.spacex.basicfeature.presentation.RocketsEvent.OpenWebBrowserWithDetails
import com.bhojak.spacex.basicfeature.presentation.RocketsIntent.RefreshRockets
import com.bhojak.spacex.basicfeature.presentation.RocketsIntent.RocketClicked
import com.bhojak.spacex.basicfeature.presentation.RocketsUiState.PartialState
import com.bhojak.spacex.basicfeature.presentation.RocketsUiState.PartialState.Error
import com.bhojak.spacex.basicfeature.presentation.RocketsUiState.PartialState.Fetched
import com.bhojak.spacex.basicfeature.presentation.RocketsUiState.PartialState.Loading
import com.bhojak.spacex.basicfeature.presentation.mapper.toPresentationModel
import com.bhojak.spacex.core.presentation.mvi.BaseViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

private const val HTTP_PREFIX = "http"
private const val HTTPS_PREFIX = "https"

@HiltViewModel
class RocketsViewModel @Inject constructor(
    private val getRocketsUseCase: GetRocketsUseCase,
    private val refreshRocketsUseCase: RefreshRocketsUseCase,
    savedStateHandle: SavedStateHandle,
    rocketsInitialState: RocketsUiState,
) : BaseViewModel<RocketsUiState, PartialState, RocketsEvent, RocketsIntent>(
        savedStateHandle = savedStateHandle,
        initialState = rocketsInitialState,
    ) {

    init {
        observeRockets()
    }

    override fun mapIntents(intent: RocketsIntent): Flow<PartialState> = when (intent) {
        is RefreshRockets -> refreshRockets()
        is RocketClicked -> rocketClicked(intent.uri)
    }

    override fun reduceUiState(
        previousState: RocketsUiState,
        partialState: PartialState,
    ): RocketsUiState = when (partialState) {
        is Loading -> previousState.copy(
            isLoading = true,
            isError = false,
        )
        is Fetched -> previousState.copy(
            isLoading = false,
            rockets = partialState.list,
            isError = false,
        )
        is Error -> previousState.copy(
            isLoading = false,
            isError = true,
        )
    }

    private fun observeRockets() = acceptChanges(
        getRocketsUseCase()
            .map { result ->
                result.fold(
                    onSuccess = { rocketList ->
                        Fetched(rocketList.map { it.toPresentationModel() })
                    },
                    onFailure = {
                        Error(it)
                    },
                )
            }
            .onStart {
                emit(Loading)
            },
    )

    private fun refreshRockets(): Flow<PartialState> = flow<PartialState> {
        refreshRocketsUseCase()
            .onFailure {
                emit(Error(it))
            }
    }.onStart {
        emit(Loading)
    }

    private fun rocketClicked(uri: String): Flow<PartialState> = flow {
        if (uri.startsWith(HTTP_PREFIX) || uri.startsWith(HTTPS_PREFIX)) {
            setEvent(OpenWebBrowserWithDetails(uri))
        }
    }
}
