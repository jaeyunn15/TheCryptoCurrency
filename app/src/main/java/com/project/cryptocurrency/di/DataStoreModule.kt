package com.project.cryptocurrency.di

import android.content.Context
import com.project.cryptocurrency.data.datasource.local.CurrencyLocalSource
import com.project.cryptocurrency.data.datasource.local.LocalDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataStoreModule {

    @Provides
    @Singleton
    fun provideLocalDataSource(@ApplicationContext appContext: Context): CurrencyLocalSource {
        return LocalDataSource(appContext)
    }
}