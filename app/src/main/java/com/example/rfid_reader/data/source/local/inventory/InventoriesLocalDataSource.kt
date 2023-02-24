package com.example.rfid_reader.data.source.local.inventory

import com.example.rfid_reader.data.Result
import com.example.rfid_reader.data.source.inventory.InventoriesDataSource
import com.example.rfid_reader.data.source.inventory.Inventory
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class InventoriesLocalDataSource internal constructor(
    private val inventoriesDao: InventoriesDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : InventoriesDataSource {

    override fun getInventoriesStream(): Flow<Result<List<Inventory>>> {
        return inventoriesDao.observeInventories().map {
            Result.Success(it)
        }
    }

    override suspend fun getInventories(): Result<List<Inventory>> = withContext(ioDispatcher) {
        return@withContext try {
            Result.Success(inventoriesDao.getInventories())
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}