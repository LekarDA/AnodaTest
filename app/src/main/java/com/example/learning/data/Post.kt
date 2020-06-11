package com.example.learning.data

import com.google.gson.annotations.SerializedName


data class Card(
    @SerializedName("nickname") val nickname: String,
    @SerializedName("city") val city: String,
    @SerializedName("avatar_url") val avatarImage: String,
    @SerializedName("photo") val photo: String,
    @SerializedName("liked_by") val list_liked_by: List<User>,
    @SerializedName("description") val description: String
    )

data class User(
    @SerializedName("id") val id: String,
    @SerializedName("nick") val nick: String
)