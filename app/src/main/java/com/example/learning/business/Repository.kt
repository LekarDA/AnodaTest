package com.example.learning.business

import android.content.Context

interface Repository {
    fun getJsonDataFromAsset(context: Context, fileName: String): String?
}