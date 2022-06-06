package com.project.cryptocurrency.data.model

import com.google.gson.annotations.SerializedName

/*{
    "id": "bitcoin",
    "symbol": "btc",
    "name": "Bitcoin",
    "image": "https://assets.coingecko.com/coins/images/1/large/bitcoin.png?1547033579",
    "current_price": 39140981,

    "market_cap_rank": 1,

    "high_24h": 39177998,
    "low_24h": 37057458,

    "price_change_24h": 1843335,
    "price_change_percentage_24h": 4.94223,
    "last_updated": "2022-06-06T06:28:30.610Z"
}*/

data class CoinMarketResponseItem(
    @SerializedName("id")
    val id: String,

    @SerializedName("symbol")
    val symbol: String,

    @SerializedName("image")
    val image: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("market_cap_rank")
    val market_cap_rank: Int,

    @SerializedName("current_price")
    val current_price: Double,

    @SerializedName("high_24h")
    val high_24h: Double,

    @SerializedName("low_24h")
    val low_24h: Double,

    @SerializedName("price_change_24h")
    val price_change_24h: Double,

    @SerializedName("price_change_percentage_24h")
    val price_change_percentage_24h: Double,

    @SerializedName("last_updated")
    val last_updated: String
)