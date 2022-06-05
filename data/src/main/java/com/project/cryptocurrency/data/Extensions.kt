package com.project.cryptocurrency.data

import com.project.cryptocurrency.domain.ApiResult
import retrofit2.HttpException
import retrofit2.Response

suspend fun <T> getResult(apiCall: suspend () -> Response<T>): ApiResult<T> {
    try {
        val response = apiCall()

        if (response.isSuccessful) {
            val body = response.body()
            body?.let {
                return ApiResult.success(body)
            }
        }

        return ApiResult.error("error")

    } catch (e: HttpException) {
        return ApiResult.error("error")

    } catch (e: Exception) {
        return ApiResult.error("error")
    }
}