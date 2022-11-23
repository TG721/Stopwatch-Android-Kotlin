package com.tengizmkcorp.stopwatch.ui.element.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tengizmkcorp.stopwatch.databinding.FlagItemBinding
import com.tengizmkcorp.stopwatch.ui.element.model.FlagModel

class FlagItemAdapter() :
    ListAdapter<FlagModel, FlagItemAdapter.FlagItemViewHolder>(ItemDiffCallback()) {

    inner class FlagItemViewHolder(private val binding: FlagItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind() {

            val source = getItem(absoluteAdapterPosition)
            binding.apply {
               textView.text = source.time
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlagItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = FlagItemBinding.inflate(layoutInflater, parent, false)
        return FlagItemViewHolder(binding)

    }

    override fun onBindViewHolder(holder: FlagItemViewHolder, position: Int) {
        return holder.bind()
    }


    private class ItemDiffCallback : DiffUtil.ItemCallback<FlagModel>() {
        override fun areItemsTheSame(
            oldItem: FlagModel,
            newItem: FlagModel,
        ): Boolean =
            oldItem.time == newItem.time

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(
            oldItem: FlagModel,
            newItem: FlagModel,
        ): Boolean =
            oldItem == newItem

    }
}
