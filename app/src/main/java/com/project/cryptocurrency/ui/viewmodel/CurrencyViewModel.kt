package com.project.cryptocurrency.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.project.cryptocurrency.domain.entity.CoinMarketInfo
import com.project.cryptocurrency.domain.usecase.GetAllCoinsMarketInfoUseCase
import com.project.cryptocurrency.ui.intent.CurrencyIntent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrencyViewModel @Inject constructor(
    private val getAllCoinsMarketInfoUseCase: GetAllCoinsMarketInfoUseCase
) : ViewModel() {

    val currencyIntent = Channel<CurrencyIntent>(Channel.UNLIMITED)

    private val _allCoinsMarketInfoFlow = MutableStateFlow<ArrayList<CoinMarketInfo>?>(null)
    val allCoinsMarketInfoFlow: LiveData<ArrayList<CoinMarketInfo>?> get() =  _allCoinsMarketInfoFlow.asLiveData()

    init {
        checkCurrencyIntent()
        viewModelScope.launch { currencyIntent.send(CurrencyIntent.getAllCoins) }
    }

    private fun checkCurrencyIntent() {
        viewModelScope.launch {
            currencyIntent.receiveAsFlow().collectLatest { CurrencyIntent ->
                when(CurrencyIntent) {
                    com.project.cryptocurrency.ui.intent.CurrencyIntent.getAllCoins -> {
                        getAllCoinsList()
                    }
                    is CurrencyIntent.saveFavoriteCoin -> {

                    }
                }
            }
        }
    }

    private fun getAllCoinsList() {
        viewModelScope.launch (Dispatchers.IO) {
            val result = getAllCoinsMarketInfoUseCase.invoke("krw")
            result.onEach {
                _allCoinsMarketInfoFlow.value = it
            }.launchIn(viewModelScope)
        }
    }

}