package com.project.cryptocurrency.domain.entity

import com.project.cryptocurrency.domain.ApiResult

interface EntityMapper<FROM, TO> {
    fun map(model: FROM): TO
}

suspend fun <T> returnMapper(
    apiResult: suspend () -> ApiResult<T>
): ApiResult<T> {
    val apiResponse = apiResult.invoke()
    return if (apiResponse.status == ApiResult.Status.SUCCESS) {
        if (apiResponse.responseData != null) {
            ApiResult.success(apiResponse.responseData)
        } else {
            ApiResult.error(apiResponse.error)
        }
    } else {
        ApiResult.error(apiResponse.error)
    }
}

fun <T> ApiResult<T>.checkSuccessResult(): Boolean {
    return this.status == ApiResult.Status.SUCCESS
}