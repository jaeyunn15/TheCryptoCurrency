package com.project.cryptocurrency.ui.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.TopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.project.cryptocurrency.domain.entity.CoinExchangeInfo
import com.project.cryptocurrency.ui.MainViewModel
import com.project.cryptocurrency.ui.intent.MainIntent
import com.project.cryptocurrency.ui.ui.item.VerticalListItemSmall
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListContentView(
    onClick: (id: String) -> Unit
) {
    val viewModel = hiltViewModel<MainViewModel>()
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column(modifier = Modifier.padding(4.dp)) {
                        Text(
                            text = "Exchange Currency",
                            style = MaterialTheme.typography.labelLarge
                        )
                        Text(
                            text = "top 100 list",
                            style = MaterialTheme.typography.labelMedium
                        )
                    }
                }
            )
        },
        content = {
            MainView(
                viewModel = viewModel,
                onClick = {
                    onClick.invoke(it)
                },
                onLikeClick = {
                    scope.launch {
                        viewModel.mainIntent.send(MainIntent.saveFavoriteCurrency(it))
                    }
                }
            )
        }
    )
}

@Composable
fun MainView(viewModel: MainViewModel, onClick: (id: String) -> Unit, onLikeClick: (data: CoinExchangeInfo) -> Unit) {
    val exchangeCurrencyData = viewModel.exchangeCurrencyListLiveData.observeAsState().value
    exchangeCurrencyData?.let {
        VerticalListView(it, onClick = onClick, onLikeClick = onLikeClick)
    }

}

@Composable
fun VerticalListView(data: List<CoinExchangeInfo>, onClick: (id: String) -> Unit, onLikeClick: (data: CoinExchangeInfo) -> Unit) {
    val list = remember { data }
    LazyColumn {
        items(
            items = list,
            itemContent = { item ->
                VerticalListItemSmall(item = item, onClick = onClick, onLikeClick = onLikeClick)
                ListItemDivider()
            }
        )
    }
}

@Composable
private fun ListItemDivider() {
    androidx.compose.material.Divider(
        modifier = Modifier.padding(horizontal = 12.dp, vertical = 12.dp),
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.08f)
    )
}