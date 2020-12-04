package com.devmasterteam.motivation.infra

import android.content.Context
import android.content.SharedPreferences

class SecurityPreferences(context: Context) {

    private val msharedPreferences = context.getSharedPreferences("Motivation", Context.MODE_PRIVATE)

    fun StoreString (key: String, value: String){
        msharedPreferences.edit().putString(key, value).apply()
    }

    fun getString (key: String): String {
        return msharedPreferences.getString(key,"") ?: ""
    }


}