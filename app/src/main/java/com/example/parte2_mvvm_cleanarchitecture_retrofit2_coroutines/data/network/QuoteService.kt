package com.example.parte2_mvvm_cleanarchitecture_retrofit2_coroutines.data.network

import com.example.parte2_mvvm_cleanarchitecture_retrofit2_coroutines.core.RetrofitHelper
import com.example.parte2_mvvm_cleanarchitecture_retrofit2_coroutines.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class QuoteService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getQuotes():List<QuoteModel>{
        return withContext(Dispatchers.IO){
            val response = retrofit.create(QuoteApiClient::class.java).getAllQuotes()
            response.body() ?: emptyList()
        }

    }
}