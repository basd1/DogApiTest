package com.bastian.marveltest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bastian.marveltest.presentation.list.DogListScreen
import com.bastian.marveltest.ui.theme.MarvelTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MarvelTestTheme {

                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "list") {
                    composable("list") { DogListScreen(navController) }
                }
            }
        }
    }
}
