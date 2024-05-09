package org.d3if0072.assessment2mobpro.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import org.d3if0072.assessment2mobpro.model.Laptop

@Dao
interface LaptopDao {

    @Insert
    suspend fun insert(laptop: Laptop)

    @Update
    suspend fun update(laptop: Laptop)

    @Query("SELECT * FROM laptop ORDER BY stok DESC")
    fun getLaptop(): Flow<List<Laptop>>

    @Query("SELECT * FROM laptop WHERE id = :id")
    suspend fun getLaptopById(id: Long): Laptop?

    @Query("DELETE FROM laptop WHERE id = :id")
    suspend fun deletById(id: Long)
}