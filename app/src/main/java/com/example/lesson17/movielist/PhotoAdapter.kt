package com.example.lesson17.movielist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.lesson17.models.PhotosModel
import com.bumptech.glide.Glide
import com.example.lesson17.databinding.PhotoItemBinding

class PhotoAdapter() : RecyclerView.Adapter<MysimpleViewHolder>() {
    private var data: List<PhotosModel> = emptyList()
    fun setData(data: List<PhotosModel>){
        this.data = data
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MysimpleViewHolder {
        return MysimpleViewHolder(
            PhotoItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MysimpleViewHolder, position: Int) {
        val item = data.getOrNull(position)

        with(holder.binding) {
            title.text = item?.camera?.full_name ?: ""
            date.text = item?.earth_date ?: ""
            rover.text = item?.rover?.name ?: ""
            item?.let {
                Glide
                    .with(image.context)
                    .load(it.img_src)
                    .into(image)
            }
        }
    }
}
class  MysimpleViewHolder(val binding: PhotoItemBinding) : RecyclerView.ViewHolder(binding.root)