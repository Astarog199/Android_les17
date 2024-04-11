package com.example.lesson17.movielist

import com.example.lesson17.API.retrofit
import com.example.lesson17.models.PhotosModel
import kotlinx.coroutines.delay

class MovieListRepository {
    suspend fun getPremieres(year: Int, month: String) : List<PhotosModel>{
        delay(2000)
        return retrofit.movies().items
    }
}