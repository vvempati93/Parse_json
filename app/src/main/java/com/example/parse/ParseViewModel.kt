package com.example.parse

import android.util.Log
import org.json.JSONArray
import org.json.JSONObject
import org.json.JSONTokener
import java.net.URL

data class CountryInfo(val name: String,
                       val region: String,
                       val code: String,
                       val capital: String)
class ParseViewModel {
    fun parseJson(): List<CountryInfo>?{
        try {
            val apiResponse = URL("https://gist.githubusercontent.com/peymano-wmt/32dcb892b06648910ddd40406e37fdab/raw/db25946fd77c5873b0303b858e861ce724e0dcd0/countries.json").readText()
            println(apiResponse)
            val formattedList = mutableListOf<CountryInfo>()
            //format apiResponse into list
            val jsonArray = JSONTokener(apiResponse) as JSONArray
            for(countryJsonIndex in 0 until jsonArray.length()){
                val name = jsonArray.getJSONObject(countryJsonIndex).getString("name")
                val capital = jsonArray.getJSONObject(countryJsonIndex).getString("capital")
                val code = jsonArray.getJSONObject(countryJsonIndex).getString("code")
                val region = jsonArray.getJSONObject(countryJsonIndex).getString("region")
                val countryInfo = CountryInfo(name,region, code, capital)
                formattedList.add(countryInfo)
            }
            return formattedList
            Log.d("Testing We Got API Response", apiResponse)
        }catch (error: Error){
            println("This is the error ")
        }
        return null
    }
}