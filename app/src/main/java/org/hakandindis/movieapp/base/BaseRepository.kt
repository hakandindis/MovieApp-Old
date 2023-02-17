package org.hakandindis.movieapp.base

import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.hakandindis.movieapp.data.model.ErrorResponse
import org.hakandindis.movieapp.utils.NetworkResult
import retrofit2.HttpException

abstract class BaseRepository {

    suspend fun <T> safeApiRequest(
        apiRequest: suspend () -> T
    ): NetworkResult<T> {
        return withContext(Dispatchers.IO) {
            try {
                NetworkResult.Success(apiRequest.invoke())
            } catch (throwable: Throwable) {
                when (throwable) {
                    is HttpException -> {
                        NetworkResult.Error(
                            false,
                            parseErrorBody(throwable.response()?.errorBody()?.string())
                        )
                    }
                    else -> NetworkResult.Error(true, throwable.localizedMessage)
                }
            }
        }
    }
}

private fun parseErrorBody(error: String?): String {
    error?.let {
        return try {
            val errorResponse = Gson().fromJson(error, ErrorResponse::class.java)
            val errorMessage = errorResponse.status?.errorMessage
            errorMessage ?: "Bilinmeyen bir hata oluştu"
        } catch (e: Exception) {
            "Bilinmeyen bir hata oluştu"
        }
    }

    return "Bilinmeyen bir hata oluştu"
}