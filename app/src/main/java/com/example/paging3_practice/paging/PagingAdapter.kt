package com.example.paging3_practice.paging

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.paging3_practice.databinding.ItemQuoteBinding
import com.example.paging3_practice.entities.Results

class PagingAdapter : PagingDataAdapter<Results, PagingAdapter.QuoteViewHolder>(diff_callBack) {

    inner class QuoteViewHolder(val binding : ItemQuoteBinding) : RecyclerView.ViewHolder(binding.root)

    companion object{
        private val diff_callBack = object : DiffUtil.ItemCallback<Results>(){
            override fun areItemsTheSame(oldItem: Results, newItem: Results): Boolean {
                return oldItem._id == newItem._id
            }

            override fun areContentsTheSame(oldItem: Results, newItem: Results): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        val binding = ItemQuoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return QuoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        getItem(position)?.let {
            holder.binding.quoteTv.text = "${it.content} \nby : ${it.author}"
        }

    }
}