package com.project.cryptocurrency.domain.entity

data class CoinExchangeInfo(
    val country: String?,
    val description: String?,
    val isTradingIncentive: Boolean?,
    val coinId: String,
    val image: String?,
    val coinName: String?,
    val tradeVolume24h: Double?,
    val tradeVolume24hNormalized: Double?,
    val trustScore: Int?,
    val trustScoreRank: Int?,
    val url: String?,
    val establishedYear: Int?
)