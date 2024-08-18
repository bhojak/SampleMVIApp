package com.bhojak.spacex.database
/*
     * Bhupendra Bhojak
*/
import androidx.room.Database
import androidx.room.RoomDatabase
import com.bhojak.spacex.basicfeature.data.local.dao.RocketDao
import com.bhojak.spacex.basicfeature.data.local.model.RocketCached

private const val DATABASE_VERSION = 1

@Database(
    entities = [RocketCached::class],
    version = DATABASE_VERSION,
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun rocketDao(): RocketDao
}
