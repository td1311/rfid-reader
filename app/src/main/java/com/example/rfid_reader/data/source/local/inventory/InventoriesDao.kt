package com.example.rfid_reader.data.source.local.inventory

import androidx.room.Dao
import androidx.room.Query
import com.example.rfid_reader.data.source.inventory.Inventory
import kotlinx.coroutines.flow.Flow

@Dao
interface InventoriesDao {

    @Query("SELECT * FROM inventories")
    fun observeInventories(): Flow<List<Inventory>>

    @Query("SELECT * FROM inventories")
    suspend fun getInventories(): List<Inventory>
}