package com.example.learning.business

import android.content.Context
import com.example.learning.data.Card
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken

class InteractorImpl : Interactor {

    private val FILE_NAME = "Data.json"
    private var json : String? = null


    override fun getData(context :  Context): List<Card> {
        val repository = RepositoryImpl()
        json = repository.getJsonDataFromAsset(context, FILE_NAME)
        return convertStringToObject(json)
    }

    private fun convertStringToObject(json: String?): List<Card> {
        val builder = GsonBuilder()
        val gson = builder.create()

        val listPersonType = object : TypeToken<List<Card>>() {}.type
        var listOfCards: List<Card> = gson.fromJson(json, listPersonType)

        return listOfCards
    }
}