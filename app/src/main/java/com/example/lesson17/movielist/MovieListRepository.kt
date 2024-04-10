package com.example.lesson17.movielist

import com.example.lesson17.models.MovieModel
import com.example.lesson17.API.retrofit
import kotlinx.coroutines.delay

class MovieListRepository {
    suspend fun getPremieres(year: Int, month: String) : List<MovieModel>{
        delay(2000)
        return retrofit.movies(year, month).items
    }
}