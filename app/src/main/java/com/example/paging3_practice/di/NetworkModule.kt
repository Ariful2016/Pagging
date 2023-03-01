package com.example.paging3_practice.di

import com.example.paging3_practice.network.QuotaApi
import com.example.paging3_practice.utils.Const
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {
    @Singleton
    @Provides
    fun getRetrofitBuilder() : Retrofit.Builder{
        return Retrofit.Builder().baseUrl(Const.base_url)
            .addConverterFactory(GsonConverterFactory.create())
    }

    @Singleton
    @Provides
    fun getQuoteApi(retrofit: Retrofit.Builder) : QuotaApi{
        return retrofit.build().create(QuotaApi::class.java)
    }
}