package com.example.paging3_practice.paging

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.paging3_practice.databinding.ItemQuoteProgressBinding

class LoaderAdapter : LoadStateAdapter<LoaderAdapter.LoaderViewHolder>() {

    class LoaderViewHolder(val binding: ItemQuoteProgressBinding):
            RecyclerView.ViewHolder(binding.root){
                fun bindState(loadState: LoadState){
                    binding.quoteTvProgress.isVisible = loadState is LoadState.Loading
                }
            }

    override fun onBindViewHolder(holder: LoaderViewHolder, loadState: LoadState) {
        holder.bindState(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoaderViewHolder {
        return LoaderViewHolder( ItemQuoteProgressBinding.inflate(LayoutInflater.from(parent.context), parent,false))
    }
}