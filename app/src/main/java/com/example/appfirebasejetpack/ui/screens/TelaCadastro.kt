package com.example.appfirebasejetpack.ui.screens

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appfirebasejetpack.ui.navigation.Routes
import com.example.appfirebasejetpack.viewmodel.AuthState
import com.example.appfirebasejetpack.viewmodel.AuthViewModel

@Composable
fun TelaCadastro(
    modifier: Modifier = Modifier,
    navController: NavController,
    authViewModel: AuthViewModel
) {
    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    val authState = authViewModel.authstate.observeAsState()
    val context = LocalContext.current

    LaunchedEffect(authState.value) {
        when (authState.value) {
            is AuthState.Authenticated -> navController.navigate(Routes.Dashboard)
            is AuthState.Error -> Toast.makeText(
                context,
                (authState.value as AuthState.Error).message, Toast.LENGTH_SHORT
            ).show()

            else -> Unit
        }
    }

    Column (
        modifier
            .fillMaxSize()
            .background(Color(26,26,26)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Cadastre-se", fontSize = 32.sp, color = Color.Cyan)

        Spacer(modifier.height(16.dp))

        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
            },
            label = {
                Text(text = "Email")
            },
            colors = TextFieldDefaults.colors(
                unfocusedIndicatorColor = Color.Cyan,
                unfocusedLabelColor = Color.Cyan,
                unfocusedContainerColor = Color(46,46,46),
                unfocusedTextColor = Color.White,

                focusedIndicatorColor = Color.Cyan,
                focusedLabelColor = Color.Cyan,
                focusedContainerColor = Color(60,60,60),
                focusedTextColor = Color.White,

                cursorColor = Color.Cyan

            ),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                // Serve para quando der o enter ele ir para o próximo campo
                imeAction = ImeAction.Next
            )
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
            },
            label = {
                Text(text = "Senha")
            },
            colors = TextFieldDefaults.colors(
                unfocusedIndicatorColor = Color.Cyan,
                unfocusedLabelColor = Color.Cyan,
                unfocusedContainerColor = Color(46,46,46),
                unfocusedTextColor = Color.White,

                focusedIndicatorColor = Color.Cyan,
                focusedLabelColor = Color.Cyan,
                focusedContainerColor = Color(60,60,60),
                focusedTextColor = Color.White,

                cursorColor = Color.Cyan

            ),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            )
        )

        Spacer(modifier.height(16.dp))

        OutlinedButton(
            onClick = {
                authViewModel.signup(email, password)
            },
            enabled = authState.value != AuthState.Loading,
            colors = ButtonColors(
                containerColor = Color(26,26,26),
                contentColor = Color.White,
                disabledContentColor = Color.Cyan,
                disabledContainerColor = Color(26,26,26)
            ),
            border = BorderStroke(1.dp, Color.Cyan)
        ) {
            Text(text = "Criar Conta", color = Color.Cyan)
        }

        Spacer(modifier.height(8.dp))

        TextButton(onClick = {
            navController.navigate(Routes.TelaLogin)
        }) {
            Text(text = "Você já tem uma conta?", color = Color.Cyan)
        }
    }
}