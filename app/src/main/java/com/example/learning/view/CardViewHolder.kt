package com.example.learning.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.learning.R
import com.example.learning.data.Card
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView
import java.lang.StringBuilder

class CardViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {

    private var avaterImage : CircleImageView? = null
    private var nickname : TextView? = null
    private var city : TextView? = null
    private var photo : ImageView? = null
    private var likedList : TextView? = null
    private var description : TextView? = null
    private var nick : TextView? = null

    private val menu: ImageView
    private val like: ImageView
    private val message: ImageView
    private val shared: ImageView
    private val save: ImageView


    init {
        avaterImage = itemView.findViewById(R.id.civ_avatar)
        nickname = itemView.findViewById(R.id.tv_nick)
        city = itemView.findViewById(R.id.tv_city)
        photo = itemView.findViewById(R.id.iv_photo)
        likedList = itemView.findViewById(R.id.tv_liked_list)
        description = itemView.findViewById(R.id.tv_description)
        nick = itemView.findViewById(R.id.tv_nickname)

        menu = itemView.findViewById(R.id.iv_menu)
        menu.setOnClickListener(this)
        like = itemView.findViewById(R.id.iv_like)
        like.setOnClickListener(this)
        message = itemView.findViewById(R.id.iv_comment)
        message.setOnClickListener(this)
        shared = itemView.findViewById(R.id.iv_share)
        shared.setOnClickListener(this)
        save = itemView.findViewById(R.id.iv_save)
        save.setOnClickListener(this)
    }

    fun onBindViewHolder(card: Card){
        Picasso.with(itemView.context).load(card.avatarImage).into(avaterImage)
        nickname?.text = card.nickname
        city?.text = card.city
        Picasso.with(itemView.context).load(card.photo).into(photo)
        nick?.text = card.nickname
        description?.text = card.description
        likedList?.text = addComma(card)
    }

    private fun addComma(card: Card): String{
        val stringBuilder = StringBuilder()
        val sizeLikedList = card.list_liked_by.size
        card.list_liked_by.forEachIndexed { index, user ->
            stringBuilder.append(user.nick)
            if (index != sizeLikedList - 1)
                stringBuilder.append(", ")
        }
        return stringBuilder.toString()
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.iv_menu -> Toast.makeText(v.context,
                R.string.menu, Toast.LENGTH_SHORT).show()
            R.id.iv_like -> Toast.makeText(v.context,
                R.string.like, Toast.LENGTH_SHORT).show()
            R.id.iv_comment -> Toast.makeText(v.context,
                R.string.message, Toast.LENGTH_SHORT).show()
            R.id.iv_share -> Toast.makeText(v.context,
                R.string.share, Toast.LENGTH_SHORT).show()
            R.id.iv_save -> Toast.makeText(v.context,
                R.string.save, Toast.LENGTH_SHORT).show()
        }
    }
}