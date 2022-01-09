package com.project.cryptocurrency.data.model

import com.google.gson.annotations.SerializedName

data class ExchangeItemResponse(
    @SerializedName("country")
    val country: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("has_trading_incentive")
    val hasTradingIncentive: Boolean,

    @SerializedName("id")
    val id: String,

    @SerializedName("image")
    val image: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("trade_volume_24h_btc")
    val tradeVolume24hBtc: Double,

    @SerializedName("trade_volume_24h_btc_normalized")
    val tradeVolume24hBtcNormalized: Double,

    @SerializedName("trust_score")
    val trustScore: Int,

    @SerializedName("trust_score_rank")
    val trustScoreRank: Int,

    @SerializedName("url")
    val url: String,

    @SerializedName("year_established")
    val yearEstablished: Int
)