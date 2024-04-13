package com.example.lesson17.pagedmovielist

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.lesson17.databinding.FragmentPhotoListBinding
import com.example.lesson17.movielist.PhotoAdapter
import com.example.lesson17.movielist.PhotoListViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class PhotoListF : Fragment() {

    private var _binding : FragmentPhotoListBinding? = null
    private val binding get() = _binding!!
    private val viewModel: PhotoListViewModel by viewModels()

    private val photoAdapter=  PhotoAdapter()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPhotoListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.adapter = photoAdapter

        viewModel.photos.onEach {
            photoAdapter.setData(it)
        }.launchIn(viewLifecycleOwner.lifecycleScope)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}