package com.example.learning.business

import android.content.Context
import com.example.learning.business.InteractorImpl
import com.example.learning.business.Presenter
import com.example.learning.data.Card

class PresenterImpl : Presenter {

    override fun getListOfCards(context: Context): List<Card> {
        val interactor = InteractorImpl()
        return interactor.getData(context)
    }
}