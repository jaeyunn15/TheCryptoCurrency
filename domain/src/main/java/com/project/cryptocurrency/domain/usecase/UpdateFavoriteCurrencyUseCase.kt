package com.project.cryptocurrency.domain.usecase

import com.project.cryptocurrency.domain.entity.CoinExchangeInfo
import com.project.cryptocurrency.domain.repository.ExchangeRepository
import com.project.cryptocurrency.domain.usecase.base.UseCase
import javax.inject.Inject

class UpdateFavoriteCurrencyUseCase @Inject constructor(
    private val repository: ExchangeRepository
) : UseCase<CoinExchangeInfo, Unit>() {

    override suspend fun execute(param: CoinExchangeInfo) {
        repository.saveFavoriteCurrency(param)
    }
}