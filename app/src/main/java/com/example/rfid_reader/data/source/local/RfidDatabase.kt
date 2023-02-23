package com.example.rfid_reader.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.rfid_reader.data.source.inventory.Inventory

@Database(entities = [Inventory::class], version = 1, exportSchema = false)
abstract class RfidDatabase : RoomDatabase() {
}