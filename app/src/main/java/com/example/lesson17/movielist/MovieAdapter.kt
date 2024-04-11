package com.example.lesson17.movielist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson17.databinding.MovieItemBinding
import com.bumptech.glide.Glide
import com.example.lesson17.models.PhotosModel

class MovieAdapter() : RecyclerView.Adapter<MysimpleViewHolder>() {
    private var data: List<PhotosModel> = emptyList()

    fun setData(data: List<PhotosModel>){
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MysimpleViewHolder {

        return MysimpleViewHolder(
            MovieItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
    override fun getItemCount(): Int = data.size
    override fun onBindViewHolder(holder: MysimpleViewHolder, position: Int) {
        val item = data.getOrNull(position)
        with(holder.binding) {
            title.text = item?.camera?.full_name ?: ""
            item?.let {
                Glide
                    .with(poster.context)
                    .load(it.img_src)
                    .into(poster)
            }
        }
    }
}
class  MysimpleViewHolder(val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root)