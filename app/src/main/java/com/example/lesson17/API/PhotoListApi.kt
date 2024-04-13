package com.example.lesson17.API


import com.example.lesson17.models.PhotoList
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Headers

interface PhotoListApi {

    @Headers("X-API-KEY: $api_key")
    @GET("/mars-photos/api/v1/rovers/curiosity/photos?sol=1000")
    suspend fun movies(): PhotoList

    private companion object{
        private const val api_key = "KNssYOKcCeKz6cr88qRsa8ja8c0OrmQFHxxgnlcK"
    }
}

val retrofit = Retrofit
    .Builder()
    .client(
        OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().also {
            it.level = HttpLoggingInterceptor.Level.BODY
        }).build())
    .baseUrl("https://api.nasa.gov")
    .addConverterFactory(GsonConverterFactory.create())
    .build()
    .create(PhotoListApi::class.java)