package com.project.cryptocurrency.domain.repository

import com.project.cryptocurrency.domain.entity.CoinMarketInfo
import kotlinx.coroutines.flow.Flow

interface CurrencyRepository {
    suspend fun getAllCoinsMarket(counter: String): Flow<ArrayList<CoinMarketInfo>>
}