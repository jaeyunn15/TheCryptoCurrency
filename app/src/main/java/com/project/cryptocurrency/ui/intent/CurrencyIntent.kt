package com.project.cryptocurrency.ui.intent

import com.project.cryptocurrency.domain.entity.CoinMarketInfo

sealed class CurrencyIntent {
    object getAllCoins: CurrencyIntent()
    data class saveFavoriteCoin(private val data: CoinMarketInfo): CurrencyIntent()
}