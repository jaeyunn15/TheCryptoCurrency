package com.project.cryptocurrency.domain.usecase

import com.project.cryptocurrency.domain.entity.CoinMarketInfo
import com.project.cryptocurrency.domain.repository.CurrencyRepository
import com.project.cryptocurrency.domain.usecase.base.UseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class GetAllCoinsMarketInfoUseCase @Inject constructor(
    private val currencyRepository: CurrencyRepository
) : UseCase<String, Flow<ArrayList<CoinMarketInfo>>>() {

    override suspend fun execute(param: String): Flow<ArrayList<CoinMarketInfo>> {
        return currencyRepository.getAllCoinsMarket(param)
    }

}