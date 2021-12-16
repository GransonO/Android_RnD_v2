package com.granson.seniordeveloper.di

import android.util.Log
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Qualifier
import javax.inject.Singleton
import kotlin.math.log

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    @FirstString
    fun providesName(): String =  "I am the 1st string"

    @Singleton
    @Provides
    @SecondString
    fun providesName2(): String =  "I am the 2nd string"

    @Singleton
    @Provides
    @ThirdString
    fun providesName3(): String =  "I am the 3rd string"

    @Singleton
    @Provides
    fun provideGetValue(num: Int): Int {
        return 27 * num
    }

    @Singleton
    @Provides
    @LoggerClient
    fun createLoggerClient(): OkHttpClient {
        val logger = HttpLoggingInterceptor()
        logger.setLevel(HttpLoggingInterceptor.Level.BODY) // Log whats sent and received from request

        val client = OkHttpClient()
        client.newBuilder().addInterceptor(logger).build()
        return client;
    }

    @Singleton
    @Provides
    fun apiServiceImpl(@LoggerClient theClient: OkHttpClient): APIService{
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .client(theClient)
            .addConverterFactory(GsonConverterFactory.create()) // Json Converter instance to use (GSon, Moshi, etc)
            .build()

        return retrofit.create(APIService::class.java)
    }

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class ThirdString

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class SecondString

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class FirstString

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class LoggerClient
}