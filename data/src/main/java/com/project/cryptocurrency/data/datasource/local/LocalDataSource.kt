package com.project.cryptocurrency.data.datasource.local

import android.content.Context
import android.util.Log
import androidx.core.content.edit
import androidx.preference.PreferenceManager
import com.project.cryptocurrency.domain.entity.CoinExchangeInfo
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class LocalDataSource @Inject constructor (@ApplicationContext context: Context): CurrencyLocalSource {

    private val pref = PreferenceManager.getDefaultSharedPreferences(context)

    override fun updateFavoriteCurrency(data: CoinExchangeInfo) {
        pref.edit().putBoolean(data.coinId, data.isFavorite).apply()
    }

    override fun getAllFavoriteCurrency(): List<String> {
        return pref.all.filter {
            it.value == true
        }.map {
            it.key
        }
    }
}