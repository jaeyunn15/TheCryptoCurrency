package com.project.cryptocurrency.domain.repository

import com.project.cryptocurrency.domain.entity.CoinExchangeInfo

interface ExchangeRepository {
    suspend fun getAllExchange(pageSize:Int) : ArrayList<CoinExchangeInfo>
}