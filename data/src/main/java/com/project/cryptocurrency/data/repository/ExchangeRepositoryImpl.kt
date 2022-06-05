package com.project.cryptocurrency.data.repository

import com.project.cryptocurrency.data.datasource.ExchangeDataSource
import com.project.cryptocurrency.data.mapper.mapToEntity
import com.project.cryptocurrency.data.mapper.toEntity
import com.project.cryptocurrency.data.model.ExchangeItemResponse
import com.project.cryptocurrency.domain.ApiResult
import com.project.cryptocurrency.domain.entity.CoinExchangeInfo
import com.project.cryptocurrency.domain.entity.EntityMapper
import com.project.cryptocurrency.domain.entity.checkSuccessResult
import com.project.cryptocurrency.domain.entity.returnMapper
import com.project.cryptocurrency.domain.repository.ExchangeRepository
import javax.inject.Inject

class ExchangeRepositoryImpl @Inject constructor(
    private val exchangeDataSource: ExchangeDataSource
) : ExchangeRepository {

    override suspend fun getAllExchange(pageSize: Int): ApiResult<ArrayList<CoinExchangeInfo>> {
        val apiResponse = exchangeDataSource.getAllExchanges(pageSize)
        return if (apiResponse.checkSuccessResult()) {
            ApiResult.success(apiResponse.responseData!!.mapToEntity())
        } else {
            ApiResult.error(apiResponse.error)
        }
    }

}