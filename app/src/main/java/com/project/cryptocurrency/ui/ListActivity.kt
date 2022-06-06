package com.project.cryptocurrency.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.project.cryptocurrency.R
import com.project.cryptocurrency.domain.entity.CoinExchangeInfo
import com.project.cryptocurrency.ui.intent.MainIntent
import com.project.cryptocurrency.ui.ui.ListContentView
import com.project.cryptocurrency.ui.ui.item.VerticalListItemSmall
import com.project.cryptocurrency.ui.ui.theme.ComposeMaterial3Theme
import com.project.cryptocurrency.ui.ui.theme.TheCryptoCurrencyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeMaterial3Theme (darkTheme = false) {
                ListContentView {
                    moveToMainPage()
                }
            }
        }
    }

    private fun moveToMainPage() {
        startActivity(
            Intent(this, MainActivity::class.java)
                .addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        )
    }

    companion object {
        fun startActivity(context: Context)= Intent(context, ListActivity::class.java)
    }
}

