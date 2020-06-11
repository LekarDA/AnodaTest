package com.example.learning.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.learning.R
import com.example.learning.data.Card

class CardsAdapter: RecyclerView.Adapter<CardViewHolder>() {

    private var listOfCards : List<Card>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)
        return CardViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listOfCards?.size ?: 0
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val card : Card? = listOfCards?.get(position)
        if(card != null)
            holder.onBindViewHolder(card)
    }

    fun setData(cards: List<Card>) {
        if(cards.isEmpty().not()){
            listOfCards = cards
            notifyDataSetChanged()
        }
    }
}