package com.example.lesson17.movielist

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lesson17.models.PhotosModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PhotoListViewModel private constructor(private val repository: PhotoListRepository)
    : ViewModel() {
    constructor() : this(PhotoListRepository())

    private val _photos = MutableStateFlow<List<PhotosModel>>(emptyList())
    val photos = _photos.asStateFlow()

    init {
        loadPremieres()
    }

    private fun loadPremieres(){
        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                repository.getPremieres()
            }.fold(
                onSuccess = { _photos.value = it},
                onFailure = { Log.d("BlankViewModel", it.message ?: "")}
            )
        }
    }

    fun refresh() {
        loadPremieres()
    }
}