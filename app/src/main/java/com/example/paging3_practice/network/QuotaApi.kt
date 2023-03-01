package com.example.paging3_practice.network

import com.example.paging3_practice.entities.Quota
import retrofit2.http.GET
import retrofit2.http.Query

interface QuotaApi {
    @GET("quotes")
    suspend fun getAllQuota(
        @Query("page") page : Int
    ) : Quota
}