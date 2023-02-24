package com.example.rfid_reader.di

import android.content.Context
import com.example.rfid_reader.BuildConfig
import com.example.rfid_reader.service.inventory.InventoryApiHelper
import com.example.rfid_reader.service.inventory.InventoryApiHelperImpl
import com.example.rfid_reader.service.inventory.InventoryApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModules {

    @Singleton
    @Provides
    fun provideOkHttpClient(@ApplicationContext appContext: Context): OkHttpClient =
        OkHttpClient.Builder().build()

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun provideInventoryApiService(retrofit: Retrofit): InventoryApiService =
        retrofit.create(InventoryApiService::class.java)

    @Provides
    @Singleton
    fun provideInventoryApiHelper(inventoryApiHelper: InventoryApiHelperImpl): InventoryApiHelper =
        inventoryApiHelper
}