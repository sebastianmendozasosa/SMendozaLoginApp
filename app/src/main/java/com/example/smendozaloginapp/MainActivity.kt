package com.example.smendozaloginapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.smendozaloginapp.screens.LoginScreenRoute
import com.example.smendozaloginapp.ui.theme.SMendozaLoginAppTheme
import androidx.navigation.toRoute
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.smendozaloginapp.screens.LoginScreen
import com.example.smendozaloginapp.screens.RegisterScreen
import com.example.smendozaloginapp.screens.RegisterScreenRoute


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SMendozaLoginAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppNavigation(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = LoginScreenRoute::class
    ) {
        composable<LoginScreenRoute>{ backStackEntry ->
            val route : LoginScreenRoute = backStackEntry.toRoute()

            LoginScreen(
                navController = navController,
                initialUserData = route.userData
            )
        }

        composable<RegisterScreenRoute>{
            RegisterScreen(navController = navController)
        }

    }


}

@Preview(
    showBackground = true,
    showSystemUi = true
)


@Composable
fun GreetingPreview() {
    SMendozaLoginAppTheme {
        AppNavigation()
    }
}