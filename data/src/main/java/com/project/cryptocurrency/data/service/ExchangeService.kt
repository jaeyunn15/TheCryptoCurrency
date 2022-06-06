package com.project.cryptocurrency.data.service

import com.project.cryptocurrency.data.model.CoinMarketResponseItem
import com.project.cryptocurrency.data.model.ExchangeItemResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ExchangeService {

    @GET("exchanges")
    suspend fun getAllExchange(
        @Query("per_page") pageSize : Int
    ): Response<ArrayList<ExchangeItemResponse>>

    //https://api.coingecko.com/api/v3/coins/markets?vs_currency=krw&order=market_cap_desc&per_page=100&page=1&sparkline=false
    @GET("coins/markets")
    suspend fun getAllCoins(
        @Query("vs_currency") counter: String,
        @Query("order") order: String = "market_cap_desc",
        @Query("per_page") perPage: Int = 100,
        @Query("page") page: Int = 1,
        @Query("sparkline") sparkLine: Boolean = false
    ): Response<ArrayList<CoinMarketResponseItem>>

}