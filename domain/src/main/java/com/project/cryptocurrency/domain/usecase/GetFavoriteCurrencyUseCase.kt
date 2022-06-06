package com.project.cryptocurrency.domain.usecase

import com.project.cryptocurrency.domain.repository.ExchangeRepository
import com.project.cryptocurrency.domain.usecase.base.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class GetFavoriteCurrencyUseCase @Inject constructor(
    private val repository: ExchangeRepository
) : UseCase<Unit, List<String>>() {
    override suspend fun execute(param: Unit): List<String> {
        return repository.getAllFavoriteCurrency()
    }
}
