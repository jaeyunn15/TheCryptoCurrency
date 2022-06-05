package com.project.cryptocurrency.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.project.cryptocurrency.di.DataSourceModule_ProvideExchangeDataSourceFactory
import com.project.cryptocurrency.domain.ApiResult
import com.project.cryptocurrency.domain.entity.CoinExchangeInfo
import com.project.cryptocurrency.domain.usecase.GetAllExchanges
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAllExchanges: GetAllExchanges
) : ViewModel() {

    val exchangeCurrencyListLiveData: LiveData<ArrayList<CoinExchangeInfo>?> get() = _exchangeCurrencyListLiveData.asLiveData()
    private val _exchangeCurrencyListLiveData = MutableStateFlow<ArrayList<CoinExchangeInfo>?>(null)

    init {
        getExchangeCurrencyList()
    }

    private fun getExchangeCurrencyList() {
        viewModelScope.launch (Dispatchers.IO) {
            val currencyListState = getAllExchanges.invoke(50)
            if (currencyListState.status == ApiResult.Status.SUCCESS) {
                _exchangeCurrencyListLiveData.value = currencyListState.responseData
            } else {
                _exchangeCurrencyListLiveData.value = null
            }
        }
    }

}