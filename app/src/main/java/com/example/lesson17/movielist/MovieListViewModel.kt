package com.example.lesson17.movielist

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lesson17.models.PhotosModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MovieListViewModel private constructor(private val repository: MovieListRepository)
    : ViewModel() {
    constructor() : this(MovieListRepository())

    private  val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    private val _movies = MutableStateFlow<List<PhotosModel>>(emptyList())
    val movies = _movies.asStateFlow()

    val filterEnabled = MutableStateFlow(false)

    init {
        loadPremieres()
    }

    private fun loadPremieres(){
        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                repository.getPremieres(2022, "JANUARY")
            }.fold(
                onSuccess = { _movies.value = it},
                onFailure = { Log.d("BlankViewModel", it.message ?: "")}
            )
        }
    }

    fun refresh() {
        loadPremieres()
    }

}