package com.example.lesson17.pagedmovielist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.lesson17.R
import com.example.lesson17.databinding.ActivityMainBinding
import com.example.lesson17.databinding.FragmentMovieListBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<FragmentMovieListBinding>(this, R.layout.fragment_movie_list)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.commit {
            replace<MovieListF>(R.id.fragment_container)
            addToBackStack(MovieListF::class.java.simpleName)
        }
    }
}