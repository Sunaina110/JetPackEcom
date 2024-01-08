package com.project.jetpackecom.base

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.project.jetpackecom.signup.Signup
import com.project.jetpackecom.splash.MainActivity

@Composable
fun Navigation() {
    val navController = rememberNavController()

    /*NavHost(navController = navController, startDestination = Routes.MAIN_ACTIVITY) {
        composable(Routes.MAIN_ACTIVITY) {
            MainActivity(navigation = navController)
        }
        composable(Routes.SIGN_UP) {
            Signup(navigation = navController)
        }
    }*/
}