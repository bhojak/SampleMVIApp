package com.bhojak.spacex.basicfeature.data.remote.api

/*
     * Bhupendra Bhojak
*/
import com.bhojak.spacex.basicfeature.data.remote.model.RocketResponse
import retrofit2.http.GET

interface RocketApi {

    @GET("rockets")
    suspend fun getRockets(): List<RocketResponse>
}
