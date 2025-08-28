package com.example.appfirebasejetpack.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavGraph(navController: NavController) {
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