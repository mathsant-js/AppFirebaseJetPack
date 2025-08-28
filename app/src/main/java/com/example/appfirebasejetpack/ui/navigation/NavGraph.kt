package com.example.appfirebasejetpack.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.appfirebasejetpack.ui.screens.TelaCadastro
import com.example.appfirebasejetpack.ui.screens.TelaLogin

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Routes.TelaLogin
    ) {
        composable(Routes.TelaLogin) {
            TelaLogin(navController)
        }
        composable(Routes.TelaCadastro) {
            TelaCadastro(navController)
        }
    }
}