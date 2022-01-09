package com.project.cryptocurrency.domain.usecase

import com.project.cryptocurrency.domain.entity.CoinExchangeInfo
import com.project.cryptocurrency.domain.repository.ExchangeRepository
import com.project.cryptocurrency.domain.usecase.base.UseCase

class GetAllExchanges (
    private val exchangeRepository: ExchangeRepository
    ) : UseCase<Int, ArrayList<CoinExchangeInfo>>() {

    override suspend fun execute(param: Int): ArrayList<CoinExchangeInfo> {
        return exchangeRepository.getAllExchange(
            pageSize = param
        )
    }

}