package com.project.cryptocurrency.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.project.cryptocurrency.ui.ui.CoinListContentView
import com.project.cryptocurrency.ui.ui.theme.ComposeMaterial3Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeMaterial3Theme (darkTheme = true) {
                CoinListContentView {
                    startActivity(
                        Intent(this, ListActivity::class.java)
                    )
                }
            }
        }
    }
}