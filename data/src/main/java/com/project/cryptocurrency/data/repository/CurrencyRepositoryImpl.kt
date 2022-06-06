package com.project.cryptocurrency.data.repository

import com.project.cryptocurrency.data.datasource.CurrencyDataSource
import com.project.cryptocurrency.data.mapper.mapToEntity
import com.project.cryptocurrency.domain.ApiResult
import com.project.cryptocurrency.domain.entity.CoinMarketInfo
import com.project.cryptocurrency.domain.repository.CurrencyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CurrencyRepositoryImpl @Inject constructor(
    private val currencyDataSource: CurrencyDataSource
): CurrencyRepository {

    override suspend fun getAllCoinsMarket(counter: String): Flow<ArrayList<CoinMarketInfo>> {
        val result = currencyDataSource.getAllCoinsMarket(counter)
        return if (result.status == ApiResult.Status.SUCCESS) {
            flow {
                emit(
                    result.responseData!!.mapToEntity().toCollection(arrayListOf())
                )
            }
        } else {
            emptyFlow()
        }
    }
}