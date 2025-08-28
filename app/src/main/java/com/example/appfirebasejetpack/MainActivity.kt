package com.example.appfirebasejetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.appfirebasejetpack.ui.navigation.AppNavGraph
import com.example.appfirebasejetpack.ui.theme.AppFirebaseJetPackTheme
import com.example.appfirebasejetpack.viewmodel.AuthViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val authViewModel : AuthViewModel by viewModels()
        setContent {
            AppFirebaseJetPackTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppNavGraph(modifier = Modifier.padding(innerPadding), navController = rememberNavController(), authViewModel = authViewModel)
                }
            }
        }
    }
}