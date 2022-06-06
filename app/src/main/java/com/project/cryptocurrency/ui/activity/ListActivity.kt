package com.project.cryptocurrency.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.project.cryptocurrency.ui.ui.ListContentView
import com.project.cryptocurrency.ui.ui.theme.ComposeMaterial3Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeMaterial3Theme (darkTheme = true) {
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

}

