package com.project.cryptocurrency.domain.repository

import com.project.cryptocurrency.domain.entity.CoinExchangeInfo
import kotlinx.coroutines.flow.Flow

interface ExchangeRepository {
    suspend fun getAllExchange(pageSize:Int) : Flow<ArrayList<CoinExchangeInfo>>
    fun getAllFavoriteCurrency(): List<String>
    suspend fun saveFavoriteCurrency(data: CoinExchangeInfo)
}