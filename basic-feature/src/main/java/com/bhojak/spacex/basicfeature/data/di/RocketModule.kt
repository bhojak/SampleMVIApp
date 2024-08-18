package com.bhojak.spacex.basicfeature.data.di
/*
     * Bhupendra Bhojak
*/
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.bhojak.spacex.basicfeature.data.remote.api.RocketApi
import com.bhojak.spacex.basicfeature.data.repository.RocketRepositoryImpl
import com.bhojak.spacex.basicfeature.domain.repository.RocketRepository
import com.bhojak.spacex.basicfeature.domain.usecase.GetRocketsUseCase
import com.bhojak.spacex.basicfeature.domain.usecase.RefreshRocketsUseCase
import com.bhojak.spacex.basicfeature.domain.usecase.getRockets
import com.bhojak.spacex.basicfeature.domain.usecase.refreshRockets
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object RocketModule {

    @Provides
    @Singleton
    fun provideRocketApi(retrofit: Retrofit): RocketApi {
        return retrofit.create(RocketApi::class.java)
    }

    @Provides
    fun provideGetRocketsUseCase(rocketRepository: RocketRepository): GetRocketsUseCase {
        return GetRocketsUseCase {
            getRockets(rocketRepository)
        }
    }

    @Provides
    fun provideRefreshRocketsUseCase(rocketRepository: RocketRepository): RefreshRocketsUseCase {
        return RefreshRocketsUseCase {
            refreshRockets(rocketRepository)
        }
    }

    @Module
    @InstallIn(SingletonComponent::class)
    interface BindsModule {

        @Binds
        @Singleton
        fun bindRocketRepository(impl: RocketRepositoryImpl): RocketRepository
    }
}
