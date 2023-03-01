package com.example.paging3_practice

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.paging3_practice.databinding.FragmentHomeBinding
import com.example.paging3_practice.paging.LoaderAdapter
import com.example.paging3_practice.paging.PagingAdapter
import com.example.paging3_practice.viewModel.QuoteViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : Fragment() {

    lateinit var binding : FragmentHomeBinding
    lateinit var adapter : PagingAdapter
    lateinit var viewModel : QuoteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)



        viewModel  = ViewModelProvider(requireActivity())[QuoteViewModel::class.java]
        adapter = PagingAdapter()

        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.adapter = adapter.withLoadStateHeaderAndFooter(
            header = LoaderAdapter(),
            footer = LoaderAdapter()
        )

        viewModel.quoteList.observe(requireActivity()){
            adapter.submitData(lifecycle,it)
            Log.i("TAG", "onCreateView: "+it)
        }


        return binding.root



    }


}