package com.example.restapiexampleapp.utils

import retrofit2.Response

abstract class ApiResponse {

    suspend fun <T> safeApiCall(api: suspend () -> Response<T>): NetworkResult<T> {
        try {
            val response = api()
            if (response.isSuccessful) {
                val body = response.body()
                body?.let {
                    return NetworkResult.Success(body)
                } ?: return errorMessage("Body is empty")
            } else {
                return errorMessage("${response.code()} ${response.message()}")
            }
        } catch (exception: Exception) {
            return errorMessage(exception.message.toString())
        }
    }

    private fun <T> errorMessage(exception: String): NetworkResult.Error<T> =
        NetworkResult.Error(
            message = "Api call failed $exception",
            data = null
        )

}

sealed class NetworkResult<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T?): NetworkResult<T>(data)
    class Error<T>(data: T?, message: String?): NetworkResult<T>(data, message)
}