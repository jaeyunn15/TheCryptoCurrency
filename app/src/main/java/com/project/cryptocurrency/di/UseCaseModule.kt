package com.project.cryptocurrency.di

import com.project.cryptocurrency.domain.repository.ExchangeRepository
import com.project.cryptocurrency.domain.usecase.GetAllExchanges
import com.project.cryptocurrency.domain.usecase.GetFavoriteCurrencyUseCase
import com.project.cryptocurrency.domain.usecase.UpdateFavoriteCurrency
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    @ViewModelScoped
    fun provideGetAllExchanges(exchangeRepository: ExchangeRepository) = GetAllExchanges(exchangeRepository)

    @Provides
    @ViewModelScoped
    fun provideGetFavoriteCurrencyUseCase(exchangeRepository: ExchangeRepository) = GetFavoriteCurrencyUseCase(exchangeRepository)

    @Provides
    @ViewModelScoped
    fun provideUpdateFavoriteCurrency(exchangeRepository: ExchangeRepository) = UpdateFavoriteCurrency(exchangeRepository)

}