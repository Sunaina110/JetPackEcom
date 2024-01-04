package com.project.jetpackecom.splash

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.project.jetpackecom.base.Routes
import com.project.jetpackecom.signin.Signin
import com.project.jetpackecom.signup.Signup
import com.project.jetpackecom.ui.theme.JetPackEcomTheme

/*
This is the main screen of the application.
 */
class MainActivity() : ComponentActivity() {
    private val splashViewModel: SplashViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen().apply {
            setKeepOnScreenCondition {
                splashViewModel.loading.value
            }
        }
        setContent {
//            Navigation()
            JetPackEcomTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = Routes.SIGN_IN) {
                    composable(Routes.SIGN_IN) {
                        Signin(navigation = navController)
                    }
                    composable(Routes.SIGN_UP) {
                        Signup(navigation = navController)
                    }
                }
            }
        }
    }
}


