package com.example.rfid_reader.data.source.inventory

import com.example.rfid_reader.data.Result
import kotlinx.coroutines.flow.Flow

interface InventoriesDataSource {
    fun getInventoriesStream(): Flow<Result<List<Inventory>>>

    suspend fun getInventories(): Result<List<Inventory>>
}