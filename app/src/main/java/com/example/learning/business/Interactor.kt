package com.example.learning.business

import android.content.Context
import com.example.learning.data.Card

interface Interactor {
    fun getData(context: Context):List<Card>
}