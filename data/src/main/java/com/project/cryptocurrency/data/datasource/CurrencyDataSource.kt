package com.project.cryptocurrency.data.datasource

import com.project.cryptocurrency.data.model.CoinMarketResponseItem
import com.project.cryptocurrency.domain.ApiResult

interface CurrencyDataSource {
    suspend fun getAllCoinsMarket(counter: String): ApiResult<ArrayList<CoinMarketResponseItem>>
}