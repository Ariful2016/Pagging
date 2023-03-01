package com.example.paging3_practice.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.paging3_practice.network.QuotaApi
import com.example.paging3_practice.paging.QuotePagingSource
import javax.inject.Inject

class QuoteRepository @Inject constructor(private val quotaApi: QuotaApi){

    fun getQuotes()= Pager(
        config = PagingConfig(pageSize = 20, maxSize = 100),
        pagingSourceFactory = { QuotePagingSource(quotaApi)}
    ).liveData
}