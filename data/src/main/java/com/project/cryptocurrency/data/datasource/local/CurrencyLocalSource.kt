package com.project.cryptocurrency.data.datasource.local

import com.project.cryptocurrency.domain.entity.CoinExchangeInfo

interface CurrencyLocalSource {
    fun updateFavoriteCurrency(data: CoinExchangeInfo)
    fun getAllFavoriteCurrency(): List<String>
}