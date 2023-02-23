package com.example.rfid_reader.service.inventory

import com.example.rfid_reader.data.source.inventory.Inventory
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface InventoryApiService {

    @GET("/inventories/list?limit={limit}")
    suspend fun getInventories(@Path("limit") limit: Int): Response<List<Inventory>>
}