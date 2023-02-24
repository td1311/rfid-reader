package com.example.rfid_reader.di

import android.content.Context
import androidx.room.Room
import com.example.rfid_reader.data.source.local.RfidDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDataBase(@ApplicationContext context: Context): RfidDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            RfidDatabase::class.java,
            "RFID.db"
        ).build()
    }
}