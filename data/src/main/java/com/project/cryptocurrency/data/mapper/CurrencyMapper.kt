package com.project.cryptocurrency.data.mapper

import com.project.cryptocurrency.data.model.CoinMarketResponseItem
import com.project.cryptocurrency.domain.entity.CoinMarketInfo

internal fun ArrayList<CoinMarketResponseItem>.mapToEntity(): ArrayList<CoinMarketInfo> {
    return this.map { it.mapToEntity() }.toCollection(arrayListOf())
}

internal fun CoinMarketResponseItem.mapToEntity(): CoinMarketInfo {
    return CoinMarketInfo(
        coinId = this.id,
        symbol = this.symbol,
        coinImage = this.image,
        coinName = this.name,
        coinRank = this.market_cap_rank,
        currentPrice = this.current_price,
        highPrice24h = this.high_24h,
        lowPrice24h = this.low_24h,
        changePrice24h = this.price_change_24h,
        changePricePercentage24h = this.price_change_percentage_24h,
        lastUpdated = this.last_updated
    )
}

