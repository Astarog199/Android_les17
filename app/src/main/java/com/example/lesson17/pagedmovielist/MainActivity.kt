package com.example.lesson17.pagedmovielist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.lesson17.R
import com.example.lesson17.databinding.ActivityMainBinding
import com.example.lesson17.databinding.FragmentPhotoListBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<FragmentPhotoListBinding>(this, R.layout.fragment_photo_list)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.commit {
            replace<PhotoListF>(R.id.fragment_container)
            addToBackStack(PhotoListF::class.java.simpleName)
        }
    }
}