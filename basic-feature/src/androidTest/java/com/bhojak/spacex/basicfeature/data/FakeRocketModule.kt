package com.bhojak.spacex.basicfeature.data

/*
     * Bhupendra Bhojak
*/
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import com.bhojak.spacex.basicfeature.data.di.RocketModule
import com.bhojak.spacex.basicfeature.domain.usecase.GetRocketsUseCase
import com.bhojak.spacex.basicfeature.domain.usecase.RefreshRocketsUseCase
import com.bhojak.spacex.core.utils.resultOf
import kotlinx.coroutines.flow.flowOf

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [RocketModule::class],
)
internal object FakeRocketModule {

    @Provides
    fun provideFakeGetRocketsUseCase(): GetRocketsUseCase {
        return GetRocketsUseCase {
            flowOf(
                Result.success(generateTestRocketsFromDomain()),
            )
        }
    }

    @Provides
    fun provideNoopRefreshRocketsUseCase(): RefreshRocketsUseCase {
        return RefreshRocketsUseCase {
            resultOf { }
        }
    }
}
