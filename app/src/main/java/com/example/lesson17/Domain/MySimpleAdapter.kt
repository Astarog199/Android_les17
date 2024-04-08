package com.example.lesson17.Domain

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson17.databinding.MySimpleListrItemBinding

class MySimpleAdapter(
    values: List<String>
) : RecyclerView.Adapter<MysimpleViewHolder>() {
    private var values = values.toMutableList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MysimpleViewHolder {
        val binding = MySimpleListrItemBinding.inflate(LayoutInflater.from(parent.context))
        return MysimpleViewHolder(binding)
    }
    override fun getItemCount(): Int = values.size
    override fun onBindViewHolder(holder: MysimpleViewHolder, position: Int) {
        val item = values[position]
        holder.binding.testFirld.text = item
    }

    /**
     * метод обновляет данные в списку
     */
    fun setData(values: List<String>) {
        this.values = values.toMutableList()
        notifyDataSetChanged()
    }

    /**
     * Метод добавляет элемент в список
     */
    fun addItem(index: Int = 0, value: String){
        values.add(index, value)
    }

    /**
     * Метод удаляет элемент из списка
     */
    fun removeItem(index: Int = 0){
        values.removeAt(index)
        notifyItemRemoved(index)
    }
}
class  MysimpleViewHolder(val binding: MySimpleListrItemBinding) : RecyclerView.ViewHolder(binding.root)