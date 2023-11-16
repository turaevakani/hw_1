package com.example.hw_1.ui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.hw_1.data.repositories.AppModel
import com.example.hw_1.data.repositories.Result
import com.example.hw_1.databinding.ItemRmBinding

class RickAndMortyAdapter(private val click:(baseResponse:Result)->Unit) : Adapter<RickAndMortyAdapter.RickAndMortyHolder>() {

    private var _list = mutableListOf<Result>()
    private val list get() = _list

    fun addData(baseResponse: List<Result>) {
        _list.addAll(baseResponse)
        notifyItemRangeInserted(_list.size, baseResponse.size - _list.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RickAndMortyHolder {
        return RickAndMortyHolder(
            ItemRmBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RickAndMortyHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class RickAndMortyHolder(private val binding: ItemRmBinding) : ViewHolder(binding.root) {
        fun bind(baseResponse: Result) {
            binding.ivRm.load(baseResponse.image)
            binding.tvName.text = baseResponse.name
            itemView.setOnClickListener {
                    click(baseResponse)
            }
            Log.e("olol", "bind: ${binding.ivRm}", )
        }
    }
}