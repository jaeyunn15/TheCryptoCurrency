package com.project.cryptocurrency.data.repository

import com.project.cryptocurrency.data.datasource.ExchangeDataSource
import com.project.cryptocurrency.data.mapper.toEntity
import com.project.cryptocurrency.domain.entity.CoinExchangeInfo
import com.project.cryptocurrency.domain.repository.ExchangeRepository

class ExchangeRepositoryImpl(
    private val exchangeDataSource: ExchangeDataSource
) : ExchangeRepository{

    override suspend fun getAllExchange(pageSize:Int): ArrayList<CoinExchangeInfo> {
        return exchangeDataSource.getAllExchanges(pageSize)
            .map {
                it.toEntity()
            }
            .toCollection(
                ArrayList<CoinExchangeInfo>()
            )
    }

}