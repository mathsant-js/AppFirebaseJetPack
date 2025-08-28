package com.example.appfirebasejetpack.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.appfirebasejetpack.ui.navigation.Routes

@Composable
fun TelaCadastro(navController: NavController) {
    Column (
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text("Tela Cadastro")
        Button(onClick = { navController.navigate(Routes.TelaLogin)}) {
            Text("Ir para login")
        }
    }
}