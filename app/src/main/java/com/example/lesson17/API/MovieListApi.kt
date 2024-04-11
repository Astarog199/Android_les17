package com.example.lesson17.API


import com.example.lesson17.models.MovieList
import com.example.lesson17.models.PagedMovieList
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import retrofit2.converter.gson.GsonConverterFactory
//https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=DEMO_KEY
interface MovieListApi {
    @GET("/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=KNssYOKcCeKz6cr88qRsa8ja8c0OrmQFHxxgnlcK")
    suspend fun movies(): MovieList
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
    .create(MovieListApi::class.java)