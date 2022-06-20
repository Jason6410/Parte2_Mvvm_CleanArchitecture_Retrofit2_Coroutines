package com.example.parte2_mvvm_cleanarchitecture_retrofit2_coroutines.domain

import com.example.parte2_mvvm_cleanarchitecture_retrofit2_coroutines.data.QuoteRepository
import com.example.parte2_mvvm_cleanarchitecture_retrofit2_coroutines.data.model.QuoteModel

class GetQuotesInteractor {
    private val repository = QuoteRepository()

    suspend operator fun invoke() : List<QuoteModel>?{
        return repository.getAllQuotes()
    }
}