package com.example.lesson17.movielist

import com.example.lesson17.API.retrofit
import com.example.lesson17.models.PhotosModel

class PhotoListRepository {
    suspend fun getPremieres() : List<PhotosModel>{
        return retrofit.movies().photos
    }
}