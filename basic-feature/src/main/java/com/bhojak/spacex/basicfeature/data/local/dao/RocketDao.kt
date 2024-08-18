package com.bhojak.spacex.basicfeature.data.local.dao

/*
     * Bhupendra Bhojak
*/
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.bhojak.spacex.basicfeature.data.local.model.RocketCached
import kotlinx.coroutines.flow.Flow

@Dao
interface RocketDao {

    @Query("SELECT * FROM RocketCached")
    fun getRockets(): Flow<List<RocketCached>>

    @Upsert
    suspend fun saveRockets(rockets: List<RocketCached>)
}
