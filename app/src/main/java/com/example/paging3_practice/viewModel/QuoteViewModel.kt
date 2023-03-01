package com.example.paging3_practice.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asFlow
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.paging3_practice.repository.QuoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(repository: QuoteRepository) : ViewModel(){

    val quoteList = repository.getQuotes().cachedIn(viewModelScope)

}