package com.project.cryptocurrency.data.service

import com.project.cryptocurrency.data.model.ExchangeItemResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ExchangeService {

    @GET("exchanges")
    suspend fun getAllExchange(
        @Query("per_page") pageSize : Int
    ): ArrayList<ExchangeItemResponse>

}