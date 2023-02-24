package com.example.rfid_reader.service.inventory

import com.example.rfid_reader.data.source.inventory.Inventory
import retrofit2.Response
import javax.inject.Inject

interface InventoryApiHelper {

    suspend fun getInventories(limit: Int): Response<List<Inventory>>
}


class InventoryApiHelperImpl @Inject constructor(private val inventoryApiService: InventoryApiService) :
    InventoryApiHelper {

    override suspend fun getInventories(limit: Int): Response<List<Inventory>> {
        return inventoryApiService.getInventories(limit)
    }
}