package com.project.cryptocurrency.data.repository

import com.project.cryptocurrency.data.datasource.ExchangeDataSource
import com.project.cryptocurrency.data.datasource.local.LocalDataSource
import com.project.cryptocurrency.data.mapper.toEntity
import com.project.cryptocurrency.domain.entity.CoinExchangeInfo
import com.project.cryptocurrency.domain.entity.checkSuccessResult
import com.project.cryptocurrency.domain.repository.ExchangeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ExchangeRepositoryImpl @Inject constructor(
    private val exchangeDataSource: ExchangeDataSource,
    private val localDataSource: LocalDataSource
) : ExchangeRepository {

    override suspend fun getAllExchange(pageSize: Int): Flow<ArrayList<CoinExchangeInfo>> {
        val apiResponse = exchangeDataSource.getAllExchanges(pageSize)
        return if (apiResponse.checkSuccessResult()) {
            flow {
                emit(
                    apiResponse.responseData!!.map {
                        it.toEntity()
                    }.toCollection(arrayListOf())
                )
            }
        } else {
            emptyFlow()
        }
    }

    override fun getAllFavoriteCurrency(): List<String> {
        return localDataSource.getAllFavoriteCurrency()
    }

    override suspend fun saveFavoriteCurrency(data: CoinExchangeInfo) {
        withContext(Dispatchers.IO) {
            localDataSource.updateFavoriteCurrency(data)
        }
    }


}