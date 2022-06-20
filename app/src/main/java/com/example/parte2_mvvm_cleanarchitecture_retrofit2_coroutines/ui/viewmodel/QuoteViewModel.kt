package com.example.parte2_mvvm_cleanarchitecture_retrofit2_coroutines.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parte2_mvvm_cleanarchitecture_retrofit2_coroutines.data.model.QuoteModel
import com.example.parte2_mvvm_cleanarchitecture_retrofit2_coroutines.data.model.QuoteProvider
import com.example.parte2_mvvm_cleanarchitecture_retrofit2_coroutines.domain.GetQuotesInteractor
import com.example.parte2_mvvm_cleanarchitecture_retrofit2_coroutines.domain.GetRandomQuotesInteractor
import kotlinx.coroutines.launch

class QuoteViewModel : ViewModel() {

    val quoteModel = MutableLiveData<QuoteModel>()
    val isLoading = MutableLiveData<Boolean>()

    var getQuotesInteractor = GetQuotesInteractor()
    var getRandomQuotesInteractor = GetRandomQuotesInteractor()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getQuotesInteractor()
            if(!result.isNullOrEmpty()){
                quoteModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }

    fun randomQuote(){
        isLoading.postValue(true)
        val quote = getRandomQuotesInteractor()
        if(quote != null){
            quoteModel.postValue(quote!!)
        }
        isLoading.postValue(false)
    }
}