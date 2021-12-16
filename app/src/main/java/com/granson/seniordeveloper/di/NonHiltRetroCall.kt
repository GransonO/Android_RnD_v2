package com.granson.seniordeveloper.di

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

class NonHiltRetroCall {

    companion object {

        private val retrofit by lazy {
            val logger =  HttpLoggingInterceptor()
            logger.setLevel(HttpLoggingInterceptor.Level.BODY)

            val client = OkHttpClient()
            client.newBuilder().addInterceptor(logger).build()

            Retrofit.Builder()
                .baseUrl("")
                .client(client)
                .build()
        }

        val api: APIService by lazy {
            retrofit.create(APIService::class.java)
        }
    }
}