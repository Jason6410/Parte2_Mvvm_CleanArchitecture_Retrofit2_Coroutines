package com.example.parte2_mvvm_cleanarchitecture_retrofit2_coroutines.data.network

import com.example.parte2_mvvm_cleanarchitecture_retrofit2_coroutines.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {
    @GET(".json")
    suspend fun getAllQuotes():Response<List<QuoteModel>>
}