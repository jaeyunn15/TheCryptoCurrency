package com.project.cryptocurrency.data.mapper

import com.project.cryptocurrency.data.model.ExchangeItemResponse
import com.project.cryptocurrency.domain.entity.CoinExchangeInfo

internal fun ExchangeItemResponse.toEntity(): CoinExchangeInfo {
    return CoinExchangeInfo(
        country = this.country,
        description = this.description,
        isTradingIncentive = this.hasTradingIncentive,
        coinId = this.id,
        image = this.image,
        coinName = this.name,
        tradeVolume24h = this.tradeVolume24hBtc,
        tradeVolume24hNormalized = this.tradeVolume24hBtcNormalized,
        trustScore = this.trustScore,
        trustScoreRank = this.trustScoreRank,
        url = this.url,
        establishedYear = this.yearEstablished
    )
}

internal fun ArrayList<ExchangeItemResponse>.mapToEntity(): ArrayList<CoinExchangeInfo> {
    return this.map { it.toEntity() }.toCollection(arrayListOf())
}