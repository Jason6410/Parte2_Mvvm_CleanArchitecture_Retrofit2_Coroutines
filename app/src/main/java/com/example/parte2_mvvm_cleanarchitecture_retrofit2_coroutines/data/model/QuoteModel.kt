package com.example.parte2_mvvm_cleanarchitecture_retrofit2_coroutines.data.model

import com.google.gson.annotations.SerializedName

data class QuoteModel (@SerializedName("quote") val quote:String,
                       @SerializedName("author") val author:String)