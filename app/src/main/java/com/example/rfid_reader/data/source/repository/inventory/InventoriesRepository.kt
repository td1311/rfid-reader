package com.example.rfid_reader.data.source.repository.inventory

import com.example.rfid_reader.data.source.local.inventory.InventoriesLocalDataSource
import com.example.rfid_reader.data.source.remote.inventory.InventoriesRemoteDataSource
import com.example.rfid_reader.data.succeeded
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class InventoriesRepository @Inject constructor(
    private val inventoriesLocalDataSource: InventoriesLocalDataSource,
    private val inventoriesRemoteDataSource: InventoriesRemoteDataSource,
) {
    suspend fun getInventories() {
        if (inventoriesRemoteDataSource.getInventories().succeeded) {

        } else {
            inventoriesLocalDataSource.getInventories()
        }
    }
}