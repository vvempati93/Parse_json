package com.example.parse

import android.util.Log
import java.net.URL

data class CountryInfo(val name: String,
                       val region: String,
                       val code: String,
                       val capital: String)
class ParseViewModel {
    fun parseJson(){
        try {
            val apiResponse = URL("https://gist.githubusercontent.com/peymano-wmt/32dcb892b06648910ddd40406e37fdab/raw/db25946fd77c5873b0303b858e861ce724e0dcd0/countries.json").readText()
            println(apiResponse)
            Log.d("Vasavi", apiResponse)
        }catch (error: Error){
            println("This is the error ")
        }
    }
}