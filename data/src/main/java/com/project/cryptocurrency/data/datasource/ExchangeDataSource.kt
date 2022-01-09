package com.project.cryptocurrency.data.datasource

import com.project.cryptocurrency.data.model.ExchangeItemResponse

interface ExchangeDataSource {
    suspend fun getAllExchanges(pageSize:Int) : ArrayList<ExchangeItemResponse>
}