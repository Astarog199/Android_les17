package com.example.lesson17.movielist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson17.databinding.MovieItemBinding
import com.bumptech.glide.Glide
import com.example.lesson17.models.MovieModel

class MovieAdapter() : RecyclerView.Adapter<MysimpleViewHolder>() {
    private var data: List<MovieModel> = emptyList()

    fun setData(data: List<MovieModel>){
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
            title.text = item?.nameRu ?: ""
            genres.text = item?.genres?.joinToString(", "){ it.genre}
            description.text = "Премьера ${item?.premiereRu}"
            countries.text = item?.countries ?.joinToString(", ") { it.country }
            item?.let {
                Glide
                    .with(poster.context)
                    .load(it.posterUrlPreview)
                    .into(poster)
            }
        }
    }
}
class  MysimpleViewHolder(val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root)