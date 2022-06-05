package com.project.cryptocurrency.ui.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.project.cryptocurrency.R
import com.project.cryptocurrency.domain.entity.CoinExchangeInfo
import com.project.cryptocurrency.ui.MainViewModel
import com.project.cryptocurrency.ui.ui.item.VerticalListItemSmall

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListContentView(
    onClick: (id: String) -> Unit
) {
    val viewModel = hiltViewModel<MainViewModel>()
    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = {
                    Column(modifier = Modifier.padding(4.dp)) {
                        Text(
                            text = "Exchange Currency",
                            style = MaterialTheme.typography.labelMedium
                        )
                        Text(
                            text = "Top 100 list",
                            style = MaterialTheme.typography.labelSmall
                        )
                    }
                },
                navigationIcon = {
                    IconButton({

                    }) {
                        Icon(
                            Icons.Filled.ArrowBack,
                            contentDescription = stringResource(id = R.string.backButton),
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
                }
            )
        }
    )
}

@Composable
fun MainView(viewModel: MainViewModel, onClick: (id: String) -> Unit) {
    val exchangeCurrencyData = viewModel.exchangeCurrencyListLiveData.observeAsState().value
    exchangeCurrencyData?.let {
        VerticalListView(it, onClick = onClick)
    }

}

@Composable
fun VerticalListView(data: List<CoinExchangeInfo>, onClick: (id: String) -> Unit) {
    val list = remember { data }
    LazyColumn {
        items(
            items = list,
            itemContent = { item ->
                VerticalListItemSmall(item = item, onClick = onClick)
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