package com.example.rfid_reader.data.source.inventory

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "inventories")
data class Inventory(
    @PrimaryKey @ColumnInfo(name = "rfidTag") var id: String = "",
    @ColumnInfo(name = "serial_number") var serialNumber: String = "",
) {
}