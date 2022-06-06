package com.project.cryptocurrency.data.datasource

import com.project.cryptocurrency.data.getResult
import com.project.cryptocurrency.data.model.CoinMarketResponseItem
import com.project.cryptocurrency.data.service.ExchangeService
import com.project.cryptocurrency.domain.ApiResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CurrencyDataSourceImpl @Inject constructor(
    private val service: ExchangeService
) : CurrencyDataSource {
    override suspend fun getAllCoinsMarket(counter: String): ApiResult<ArrayList<CoinMarketResponseItem>> = getResult {
            withContext(Dispatchers.IO) {
                service.getAllCoins(counter)
            }
        }
}