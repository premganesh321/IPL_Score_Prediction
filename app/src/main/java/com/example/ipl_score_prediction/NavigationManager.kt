package com.example.ipl_score_prediction

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Nav() {
    val navController = rememberNavController()
    val context = LocalContext.current
    NavHost(navController = navController, startDestination = "MainScreen") {
        composable("MainScreen") {
            App {
                navController.navigate("secondscreen")
            }
        }
        composable("secondscreen") {
            SecondScreen {
                navController.navigate("thirdscreen")
            }
        }
        composable("thirdscreen") {
            ThirdScreen {
                navController.navigate("fourscreen")
            }
        }
        composable("fourscreen") {
          IPLScorePredictionScreen(context = context )
        }
    }

}

