package com.project.cryptocurrency.data.datasource

import com.project.cryptocurrency.data.getResult
import com.project.cryptocurrency.data.model.ExchangeItemResponse
import com.project.cryptocurrency.data.service.ExchangeService
import com.project.cryptocurrency.domain.ApiResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ExchangeDataSourceImpl @Inject constructor(
    private val exchangeService: ExchangeService
) : ExchangeDataSource{

    override suspend fun getAllExchanges(pageSize: Int): ApiResult<ArrayList<ExchangeItemResponse>> = getResult {
        withContext(Dispatchers.IO) {
            exchangeService.getAllExchange(pageSize)
        }
    }

}