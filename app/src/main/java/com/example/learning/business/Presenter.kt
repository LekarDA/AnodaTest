package com.example.learning.business

import android.content.Context
import com.example.learning.data.Card

interface Presenter {

    fun getListOfCards(context: Context): List<Card>
}