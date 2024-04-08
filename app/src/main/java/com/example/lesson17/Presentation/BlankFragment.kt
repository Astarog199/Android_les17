package com.example.lesson17.Presentation

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lesson17.Domain.MySimpleAdapter
import com.example.lesson17.R
import com.example.lesson17.databinding.FragmentBlankBinding
import kotlin.random.Random

class BlankFragment : Fragment() {
    private var _binding : FragmentBlankBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = BlankFragment()
    }

    private val viewModel: BlankViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBlankBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 3, GridLayoutManager.VERTICAL, false)
//            LinearLayoutManager (requireContext(), LinearLayoutManager.VERTICAL, false)

        val data: List<String> = (0..100).map { it.toString() }
        val  myAdapter = MySimpleAdapter(data)
        binding.recyclerView.adapter = myAdapter

        binding.add.setOnClickListener {
            val item = Random.nextInt(100, 200).toString()
            myAdapter.addItem(5, item)
        }

        binding.remove.setOnClickListener {
            myAdapter.removeItem(1)
        }

        binding.set.setOnClickListener {
            val newData = List(100){
                Random.nextInt(0,100).toString()
            }
            myAdapter.setData(newData)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}