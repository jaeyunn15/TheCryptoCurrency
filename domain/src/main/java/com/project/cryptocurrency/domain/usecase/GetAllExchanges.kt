package com.project.cryptocurrency.domain.usecase

import com.project.cryptocurrency.domain.ApiResult
import com.project.cryptocurrency.domain.entity.CoinExchangeInfo
import com.project.cryptocurrency.domain.repository.ExchangeRepository
import com.project.cryptocurrency.domain.usecase.base.UseCase
import javax.inject.Inject

class GetAllExchanges @Inject constructor(
    private val exchangeRepository: ExchangeRepository
) : UseCase<Int, ApiResult<ArrayList<CoinExchangeInfo>>>() {

    override suspend fun execute(param: Int): ApiResult<ArrayList<CoinExchangeInfo>> {
        return exchangeRepository.getAllExchange(
            pageSize = param
        )
    }

}