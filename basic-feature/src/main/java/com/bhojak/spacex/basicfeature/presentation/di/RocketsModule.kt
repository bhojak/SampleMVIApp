package com.bhojak.spacex.basicfeature.presentation.di

/*
     * Bhupendra Bhojak
*/

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import com.bhojak.spacex.basicfeature.presentation.RocketsNavigationFactory
import com.bhojak.spacex.basicfeature.presentation.RocketsUiState
import com.bhojak.spacex.core.navigation.NavigationFactory
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
internal object RocketsViewModelModule {

    @Provides
    fun provideInitialRocketsUiState(): RocketsUiState = RocketsUiState()
}

@Module
@InstallIn(SingletonComponent::class)
internal interface RocketsSingletonModule {

    @Singleton
    @Binds
    @IntoSet
    fun bindRocketsNavigationFactory(factory: RocketsNavigationFactory): NavigationFactory
}
