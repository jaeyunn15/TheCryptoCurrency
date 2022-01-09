package com.project.cryptocurrency.data.datasource

import com.project.cryptocurrency.data.model.ExchangeItemResponse
import com.project.cryptocurrency.data.service.ExchangeService

class ExchangeDataSourceImpl (
    private val exchangeService: ExchangeService
    ) : ExchangeDataSource{

    override suspend fun getAllExchanges(pageSize: Int): ArrayList<ExchangeItemResponse>
        = exchangeService.getAllExchange(pageSize)

}