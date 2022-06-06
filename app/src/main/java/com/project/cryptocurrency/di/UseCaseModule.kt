package com.project.cryptocurrency.di

import com.project.cryptocurrency.domain.repository.CurrencyRepository
import com.project.cryptocurrency.domain.repository.ExchangeRepository
import com.project.cryptocurrency.domain.usecase.GetAllCoinsMarketInfoUseCase
import com.project.cryptocurrency.domain.usecase.GetAllExchangesUseCase
import com.project.cryptocurrency.domain.usecase.GetFavoriteCurrencyUseCase
import com.project.cryptocurrency.domain.usecase.UpdateFavoriteCurrencyUseCase
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
    fun provideGetAllExchanges(exchangeRepository: ExchangeRepository) = GetAllExchangesUseCase(exchangeRepository)

    @Provides
    @ViewModelScoped
    fun provideGetFavoriteCurrencyUseCase(exchangeRepository: ExchangeRepository) = GetFavoriteCurrencyUseCase(exchangeRepository)

    @Provides
    @ViewModelScoped
    fun provideUpdateFavoriteCurrency(exchangeRepository: ExchangeRepository) = UpdateFavoriteCurrencyUseCase(exchangeRepository)

    @Provides
    @ViewModelScoped
    fun provideGetAllCoinsMarketInfoUseCase(currencyRepository: CurrencyRepository) = GetAllCoinsMarketInfoUseCase(currencyRepository)
}