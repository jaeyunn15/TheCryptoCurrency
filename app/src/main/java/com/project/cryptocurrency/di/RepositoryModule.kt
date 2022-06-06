package com.project.cryptocurrency.di

import com.project.cryptocurrency.data.datasource.ExchangeDataSource
import com.project.cryptocurrency.data.datasource.local.LocalDataSource
import com.project.cryptocurrency.data.repository.ExchangeRepositoryImpl
import com.project.cryptocurrency.domain.repository.ExchangeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideExchangeRepository(
        exchangeDataSource: ExchangeDataSource,
        localDataSource: LocalDataSource
    ): ExchangeRepository {
        return ExchangeRepositoryImpl(
            exchangeDataSource = exchangeDataSource,
            localDataSource = localDataSource
        )
    }

}