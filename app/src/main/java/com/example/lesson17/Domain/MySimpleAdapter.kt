package com.example.lesson17.Domain

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson17.databinding.MySimpleListrItemBinding

class MySimpleAdapter(
    private val values: List<String>
) : RecyclerView.Adapter<MysimpleViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MysimpleViewHolder {
        val binding = MySimpleListrItemBinding.inflate(LayoutInflater.from(parent.context))
        return MysimpleViewHolder(binding)
    }
    override fun getItemCount(): Int = values.size
    override fun onBindViewHolder(holder: MysimpleViewHolder, position: Int) {
        val item = values[position]
        holder.binding.testFirld.text = item
    }
}
class  MysimpleViewHolder(val binding: MySimpleListrItemBinding) : RecyclerView.ViewHolder(binding.root)