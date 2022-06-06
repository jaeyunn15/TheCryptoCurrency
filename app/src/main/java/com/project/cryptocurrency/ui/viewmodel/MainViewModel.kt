package com.project.cryptocurrency.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.project.cryptocurrency.domain.entity.CoinExchangeInfo
import com.project.cryptocurrency.domain.usecase.GetAllExchangesUseCase
import com.project.cryptocurrency.domain.usecase.GetFavoriteCurrencyUseCase
import com.project.cryptocurrency.domain.usecase.UpdateFavoriteCurrencyUseCase
import com.project.cryptocurrency.ui.intent.MainIntent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAllExchangesUseCase: GetAllExchangesUseCase,
    private val getFavoriteCurrencyUseCase: GetFavoriteCurrencyUseCase,
    private val updateFavoriteCurrencyUseCase: UpdateFavoriteCurrencyUseCase
) : ViewModel() {

    val exchangeCurrencyListLiveData: LiveData<ArrayList<CoinExchangeInfo>?> get() = _exchangeCurrencyListLiveData.asLiveData()
    private val _exchangeCurrencyListLiveData = MutableStateFlow<ArrayList<CoinExchangeInfo>?>(null)

    val mainIntent = Channel<MainIntent>(Channel.UNLIMITED)

    init {
        initCheckIntent()
        viewModelScope.launch {
            mainIntent.send(MainIntent.getAllExchangeData)
        }
    }

    private fun initCheckIntent() {
        viewModelScope.launch {
            mainIntent.consumeAsFlow().collectLatest { mainIntent ->
                when (mainIntent) {
                    MainIntent.getAllExchangeData -> {
                        getExchangeCurrencyList()
                    }
                    is MainIntent.saveFavoriteCurrency -> {
                        saveFavoriteCurrency(mainIntent.data)
                    }
                }
            }
        }
    }

    private fun saveFavoriteCurrency(data: CoinExchangeInfo) {
        viewModelScope.launch (Dispatchers.IO) {
            updateFavoriteCurrencyUseCase.invoke(data)
        }
    }

    private fun getExchangeCurrencyList() {
        viewModelScope.launch (Dispatchers.IO) {
            val allCurrencyList = getAllExchangesUseCase.invoke(300)
            val allFavoriteList = flow { emit(getFavoriteCurrencyUseCase.invoke(Unit)) }.onEmpty { emit(emptyList()) }
            combine(allCurrencyList, allFavoriteList) { currencyList, favoriteList ->
                currencyList.map {
                    it.isFavorite = favoriteList.contains(it.coinId)
                }
                _exchangeCurrencyListLiveData.value = currencyList
            }.launchIn(viewModelScope)

        }
    }

}