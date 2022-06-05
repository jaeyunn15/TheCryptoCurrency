package com.project.cryptocurrency.data.datasource

import com.project.cryptocurrency.data.model.ExchangeItemResponse
import com.project.cryptocurrency.domain.ApiResult

interface ExchangeDataSource {
    suspend fun getAllExchanges(pageSize:Int) : ApiResult<ArrayList<ExchangeItemResponse>>
}