package com.project.cryptocurrency.domain.entity

data class CoinMarketInfo(
    val coinId: String,
    val symbol: String,
    val coinImage: String,
    val coinName: String,
    val coinRank: Int,
    val currentPrice: Double,
    val highPrice24h: Double,
    val lowPrice24h: Double,
    val changePrice24h: Double,
    val changePricePercentage24h: Double,
    val lastUpdated: String
)