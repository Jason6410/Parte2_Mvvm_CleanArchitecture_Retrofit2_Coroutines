package com.example.parte2_mvvm_cleanarchitecture_retrofit2_coroutines.domain

import com.example.parte2_mvvm_cleanarchitecture_retrofit2_coroutines.data.QuoteRepository
import com.example.parte2_mvvm_cleanarchitecture_retrofit2_coroutines.data.model.QuoteModel
import com.example.parte2_mvvm_cleanarchitecture_retrofit2_coroutines.data.model.QuoteProvider

class GetRandomQuotesInteractor {
    private val repository = QuoteRepository()

    operator fun invoke() : QuoteModel?{
        val quotes = QuoteProvider.quotes
        if(!quotes.isNullOrEmpty()){
            val randomNumber = (quotes.indices).random()  //(0..quotes.size).random()
            return quotes[randomNumber]
        }
        return null
    }
}