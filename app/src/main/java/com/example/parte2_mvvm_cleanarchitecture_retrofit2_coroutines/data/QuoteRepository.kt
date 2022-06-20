package com.example.parte2_mvvm_cleanarchitecture_retrofit2_coroutines.data

import com.example.parte2_mvvm_cleanarchitecture_retrofit2_coroutines.data.model.QuoteModel
import com.example.parte2_mvvm_cleanarchitecture_retrofit2_coroutines.data.model.QuoteProvider
import com.example.parte2_mvvm_cleanarchitecture_retrofit2_coroutines.data.network.QuoteService

class QuoteRepository {
    private val api = QuoteService()

    suspend fun getAllQuotes():List<QuoteModel>{
        val response = api.getQuotes()
        QuoteProvider.quotes = response
        return response
    }
}