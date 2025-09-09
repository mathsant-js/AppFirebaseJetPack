package com.example.appfirebasejetpack.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.appfirebasejetpack.data.repository.FirebaseRepository
import com.example.appfirebasejetpack.ui.navigation.Routes
import com.example.appfirebasejetpack.viewmodel.AuthViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaCreate(
    modifier: Modifier,
    navController: NavController,
    authViewModel: AuthViewModel
) {
    var repo = remember { FirebaseRepository() }
    var nome by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var telefone by remember { mutableStateOf("") }
    var mensagem by remember { mutableStateOf("") }
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "Criar Usuário", color = Color.Black) },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Voltar",
                            tint = Color.Black
                        )
                    }
                },
                actions = {
                    MenuUsuario(
                        onCriar = {},
                        onSair = {
                            authViewModel.signout()
                            navController.navigate(Routes.TelaLogin)
                        }
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Cyan
                )
            )
        }
    ) { padding ->
        Column(
            Modifier
                .background(Color(26, 26, 26))
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                Modifier
                    .padding(16.dp)
            ) {
                TextField(
                    value = nome,
                    onValueChange = {
                        nome = it
                    },
                    label = { Text(text = "Nome") },
                    placeholder = { Text(text = "Digite o seu nome") },
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
            }
            Row(
                Modifier
                    .padding(16.dp)
            ) {
                TextField(
                    value = email,
                    onValueChange = {
                        email = it
                    },
                    label = { Text(text = "Email") },
                    placeholder = { Text(text = "Digite o seu email") },
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
            }
            Row(
                Modifier
                    .padding(16.dp)
            ) {
                TextField(
                    value = telefone,
                    onValueChange = {
                        telefone = it
                    },
                    label = { Text(text = "Telefone") },
                    placeholder = { Text(text = "Digite o seu email") },
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
            }
            Row(
                Modifier
                    .padding(16.dp)
            ) {
                TextField(
                    value = mensagem,
                    onValueChange = {
                        mensagem = it
                    },
                    label = { Text(text = "Mensagem") },
                    placeholder = { Text(text = "Digite alguma mensagem") },
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
                        imeAction = ImeAction.Done
                    )
                )
            }
            Row(
                Modifier
                    .padding(16.dp)
            ) {
                OutlinedButton(
                    onClick = {
                        if (nome.isNotBlank() && email.isNotBlank()) {
                           repo.addUser(nome, email, telefone, mensagem)
                           nome = ""
                           email = ""
                           telefone = ""
                           mensagem = ""
                        }
                    },
                    colors = ButtonColors(
                        containerColor = Color(26,26,26),
                        contentColor = Color.White,
                        disabledContentColor = Color.Cyan,
                        disabledContainerColor = Color(26,26,26)
                    ),
                    border = BorderStroke(1.dp, Color.Cyan)
                ) {
                    Text(text = "Criar Usuário", color = Color.Cyan)
                }
            }
        }
    }
}