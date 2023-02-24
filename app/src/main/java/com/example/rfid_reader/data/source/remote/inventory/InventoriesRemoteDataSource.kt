package com.example.rfid_reader.data.source.remote.inventory

import com.example.rfid_reader.data.Result
import com.example.rfid_reader.data.source.inventory.InventoriesDataSource
import com.example.rfid_reader.data.source.inventory.Inventory
import com.example.rfid_reader.service.inventory.InventoryApiHelper
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow

class InventoriesRemoteDataSource internal constructor(
    private val inventoryApiHelperImpl: InventoryApiHelper,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : InventoriesDataSource {


    override fun getInventoriesStream(): Flow<Result<List<Inventory>>> {
        TODO("Not yet implemented")
    }

    override suspend fun getInventories(): Result<List<Inventory>> {
        val responseBody = inventoryApiHelperImpl.getInventories(10).body()
        return if (responseBody != null) {
            return Result.Success(responseBody)
        } else {
            Result.Error(Exception())
        }
    }
}