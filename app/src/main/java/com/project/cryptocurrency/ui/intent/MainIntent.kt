package com.project.cryptocurrency.ui.intent

import com.project.cryptocurrency.domain.entity.CoinExchangeInfo

sealed class MainIntent {

    object getAllExchangeData : MainIntent()
    data class saveFavoriteCurrency(val data: CoinExchangeInfo): MainIntent()

}