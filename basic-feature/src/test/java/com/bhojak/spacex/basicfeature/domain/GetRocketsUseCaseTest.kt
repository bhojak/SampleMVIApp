package com.bhojak.spacex.basicfeature.domain

/*
     * Bhupendra Bhojak
*/

import app.cash.turbine.test
import com.bhojak.spacex.basicfeature.domain.repository.RocketRepository
import com.bhojak.spacex.basicfeature.domain.usecase.GetRocketsUseCase
import com.bhojak.spacex.basicfeature.domain.usecase.getRockets
import com.bhojak.spacex.basicfeature.generateTestRocketFromDomain
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.io.IOException
import kotlin.coroutines.cancellation.CancellationException
import kotlin.test.assertEquals

class GetRocketsUseCaseTest {

    @RelaxedMockK
    private lateinit var rocketRepository: RocketRepository

    private lateinit var objectUnderTest: GetRocketsUseCase

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this)
        setUpGetRocketsUseCase()
    }

    @Test
    fun `should wrap result with success if repository doesn't throw`() = runTest {
        // Given
        val testRocketsFromDomain = listOf(generateTestRocketFromDomain())
        coEvery { rocketRepository.getRockets() } returns flowOf(testRocketsFromDomain)

        // When-Then
        objectUnderTest.invoke().test {
            val result = awaitItem()

            assertEquals(
                expected = Result.success(testRocketsFromDomain),
                actual = result,
            )
            awaitComplete()
        }
    }

    @Test
    fun `should retry operation if repository throws IOException`() = runTest {
        // Given
        val testException = IOException("Test message")
        val testRocketsFromDomain = listOf(generateTestRocketFromDomain())
        coEvery { rocketRepository.getRockets() } throws testException andThen flowOf(testRocketsFromDomain)

        // When-Then
        assertThrows<IOException> {
            objectUnderTest.invoke().test {
                val errorResult = awaitItem()

                assertEquals(
                    expected = Result.failure(testException),
                    actual = errorResult,
                )

                val itemsResult = awaitItem()

                assertEquals(
                    expected = Result.success(testRocketsFromDomain),
                    actual = itemsResult,
                )
            }
        }
    }

    @Test
    fun `should rethrow if repository throws CancellationException`() = runTest {
        // Given
        coEvery { rocketRepository.getRockets() } throws CancellationException()

        // When-Then
        assertThrows<CancellationException> {
            objectUnderTest.invoke()
        }
    }

    @Test
    fun `should wrap result with failure if repository throws other Exception`() = runTest {
        // Given
        val testException = Exception("Test message")
        coEvery { rocketRepository.getRockets() } throws testException

        // When-Then
        assertThrows<Exception> {
            objectUnderTest.invoke().test {
                val result = awaitItem()

                assertEquals(
                    expected = Result.failure(testException),
                    actual = result,
                )
            }
        }
    }

    private fun setUpGetRocketsUseCase() {
        objectUnderTest = GetRocketsUseCase {
            getRockets(rocketRepository)
        }
    }
}
