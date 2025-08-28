package com.example.appfirebasejetpack.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.appfirebasejetpack.ui.screens.Dashboard
import com.example.appfirebasejetpack.ui.screens.TelaCadastro
import com.example.appfirebasejetpack.ui.screens.TelaLogin
import com.example.appfirebasejetpack.viewmodel.AuthViewModel

@Composable
fun AppNavGraph(modifier: Modifier = Modifier, navController: NavHostController, authViewModel: AuthViewModel) {
    NavHost(
        navController = navController,
        startDestination = Routes.TelaLogin
    ) {
        composable(Routes.TelaLogin) {
            TelaLogin(modifier, navController, authViewModel)
        }
        composable(Routes.TelaCadastro) {
            TelaCadastro(modifier, navController, authViewModel)
        }
        composable(Routes.Dashboard) {
            Dashboard(modifier)
        }
    }
}