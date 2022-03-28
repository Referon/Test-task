package ru.referon.testtask

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import ru.referon.testtask.databinding.CardLayoutBinding
import ru.referon.testtask.model.Result

class Adapter(

) : androidx.recyclerview.widget.ListAdapter<Result, ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CardLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = getItem(position)
        holder.bind(post)
    }
}

class ViewHolder(
    private val binding: CardLayoutBinding,

) : RecyclerView.ViewHolder(binding.root) {

    fun bind(food: Result) {

        binding.apply {
            name.text = food.title
            description.text = food.analyzedInstructions[0].steps[1].step
            Glide.with(itemView)
                .load(food.image)
                .apply(RequestOptions().override(500, 500))
                .into(image)
        }
    }
}

class DiffCallback : DiffUtil.ItemCallback<Result>() {
    override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
        return oldItem == newItem
    }

}