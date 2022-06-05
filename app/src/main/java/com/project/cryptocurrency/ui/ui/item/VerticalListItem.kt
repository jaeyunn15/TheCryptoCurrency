package com.project.cryptocurrency.ui.ui.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.project.cryptocurrency.domain.entity.CoinExchangeInfo
import com.project.cryptocurrency.ui.ui.theme.ComposeMaterial3Theme


@Composable
fun VerticalListItemSmall(
    item: CoinExchangeInfo,
    modifier: Modifier = Modifier,
    onClick: (id: String) -> Unit
) {
    val typography = MaterialTheme.typography
    Row(
        modifier = Modifier
            .clickable(onClick = {
                onClick.invoke(item.coinId)
            })
            .padding(16.dp)
    ) {
        ItemImage(
            item = item,
            modifier = Modifier.padding(end = 16.dp)
        )
        Column(modifier = Modifier.weight(1f)) {
            item.coinName?.let {
                Text(
                    text = it,
                    style = typography.titleMedium
                )
            }
            item.trustScoreRank?.let {
                Text(
                    text = it.toString(),
                    style = typography.bodyMedium
                )
            }

        }
        FavIcon(modifier)
    }
}

@Composable
fun FavIcon(modifier: Modifier = Modifier) {
    val isFavourite = remember {
        mutableStateOf(true)
    }
    IconToggleButton(
        checked = isFavourite.value,
        onCheckedChange = { isFavourite.value = !isFavourite.value }
    ) {
        if (isFavourite.value) {
            Icon(
                imageVector = Icons.Filled.Favorite,
                contentDescription = null,
                modifier = modifier
            )
        } else {
            Icon(
                imageVector = Icons.Default.FavoriteBorder,
                contentDescription = null,
                modifier = modifier
            )
        }
    }
}

@Composable
fun ItemImage(item: CoinExchangeInfo, modifier: Modifier = Modifier) {
    Image(
        painter = rememberImagePainter(item.image),
        contentScale = ContentScale.Fit,
        contentDescription = null,
        modifier = modifier
            .size(80.dp, 80.dp)
            .clip(androidx.compose.material.MaterialTheme.shapes.medium)

    )
}

@Preview
@Composable
fun PreviewSmallListItem() {
    val coinInfo = CoinExchangeInfo(
        country = "U.S.A",
        description = "First Exchange Currency",
        isTradingIncentive = false,
        coinId = "3412312",
        image = "",
        coinName = "Bitcoin",
        tradeVolume24h = 0.0,
        tradeVolume24hNormalized = 0.0,
        trustScore = 80,
        trustScoreRank = 3,
        url = "",
        establishedYear = 0
    )
    ComposeMaterial3Theme {
        VerticalListItemSmall(item = coinInfo) {

        }
    }
}