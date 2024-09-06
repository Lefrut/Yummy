package com.example.data.di

import com.example.data.preferences.DataStoreManagerImpl
import com.example.domain.datastore.DataStoreManager
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class DatastoreModule {


    @Binds
    @Singleton
    abstract fun bindDatastoreManager(dataStoreManagerImpl: DataStoreManagerImpl): DataStoreManager

}