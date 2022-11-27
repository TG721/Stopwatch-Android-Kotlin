package com.tengizmkcorp.stopwatch.ui.element.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tengizmkcorp.stopwatch.databinding.FlagItemBinding
import com.tengizmkcorp.stopwatch.ui.element.model.FlagModel


class FlagItemAdapter(val items: MutableList<FlagModel>, val deleteFun: (item: FlagModel, pos: Int) -> Unit ) :
    RecyclerView.Adapter<FlagItemAdapter.ItemViewHolder>() {


    inner class ItemViewHolder(val binding: FlagItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: FlagModel) {
            val pos = bindingAdapterPosition
            binding.textView.text = item.time
            binding.deleteIV.setOnClickListener {
                deleteFun(item, pos)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            FlagItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
