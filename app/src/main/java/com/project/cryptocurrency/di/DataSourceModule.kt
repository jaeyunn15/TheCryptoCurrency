package com.project.cryptocurrency.di

import com.project.cryptocurrency.data.datasource.CurrencyDataSource
import com.project.cryptocurrency.data.datasource.CurrencyDataSourceImpl
import com.project.cryptocurrency.data.datasource.ExchangeDataSource
import com.project.cryptocurrency.data.datasource.ExchangeDataSourceImpl
import com.project.cryptocurrency.data.service.ExchangeService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideExchangeDataSource(service: ExchangeService): ExchangeDataSource {
        return ExchangeDataSourceImpl(service)
    }

    @Provides
    @Singleton
    fun provideCurrencyDataSource(service: ExchangeService): CurrencyDataSource {
        return CurrencyDataSourceImpl(service)
    }

}