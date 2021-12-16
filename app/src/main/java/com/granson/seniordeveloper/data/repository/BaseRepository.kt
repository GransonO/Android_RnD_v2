package com.granson.seniordeveloper.data.repository

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONException
import org.json.JSONObject
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException


abstract class BaseRepository {

    suspend fun <T> apiCall(apiCall: suspend () -> T): ApiResponse<T> {
        return withContext(Dispatchers.IO) {
            try {
                ApiResponse.Success(apiCall.invoke())
            } catch (e: Exception) {
                e.printStackTrace()
                Log.e("Base Repo", "cause ${e.localizedMessage}")
                when (e) {
                    is IOException -> ApiResponse.Failure(
                            ErrorHolder("Unable to connect, check your connection", 1)
                    )

                    is HttpException -> ApiResponse.Failure(extractHttpExceptions(e))

                    is UnknownHostException -> ApiResponse.Failure(
                            ErrorHolder("Unable to connect, check your connection", 1)
                    )
                    is SocketTimeoutException -> ApiResponse.Failure(
                            ErrorHolder("Unable to connect, check your connection", 1)
                    )
                    else -> ApiResponse.Failure(ErrorHolder(e.message.toString(), 1))
                }
            }
        }
    }

    private fun extractHttpExceptions(e: HttpException): ErrorHolder {
        val body = e.response()?.errorBody()
        val jsonString = body?.string()

        val message = try {
            val jsonObject = JSONObject(jsonString)
            jsonObject.getString("message")
        } catch (exception: JSONException) {
            when (e.code()) {
                500 -> {
                    "Something happened on our end, try again later"

                }
                503 -> {
                    "Service temporarily unavailable, try again in a few minutes"
                }
                else -> {
                    "Unable to complete your request, try again later"

                }
            }
        }

        val errorCode = e.response()?.code()
        return ErrorHolder(message, errorCode)
    }

}