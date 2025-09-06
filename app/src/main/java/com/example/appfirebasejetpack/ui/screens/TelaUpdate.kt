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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import java.lang.reflect.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaUpdate(
    navController: NavController
) {
    var nome by remember { mutableStateOf(TextFieldValue("")) }
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var telefone by remember { mutableStateOf(TextFieldValue("")) }
    var mensagem by remember { mutableStateOf(TextFieldValue("")) }
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "Atualizar Usuário", color = Color.Black) },
                navigationIcon = {
                    IconButton(onClick = {
                        // Voltar a tela anterior
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
                            navController.popBackStack()
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
            androidx.compose.ui.Modifier
                .background(Color(26, 26, 26))
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                androidx.compose.ui.Modifier
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
                androidx.compose.ui.Modifier
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
                androidx.compose.ui.Modifier
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
                androidx.compose.ui.Modifier
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
                androidx.compose.ui.Modifier
                    .padding(16.dp)
            ) {
                OutlinedButton(
                    onClick = {},
                    colors = ButtonColors(
                        containerColor = Color(26,26,26),
                        contentColor = Color.White,
                        disabledContentColor = Color.Cyan,
                        disabledContainerColor = Color(26,26,26)
                    ),
                    border = BorderStroke(1.dp, Color.Cyan)
                ) {
                    Text(text = "Atualizar Usuário", color = Color.Cyan)
                }
            }
        }
    }
}

/*
@Preview
@Composable
fun TelaUpdatePreview() {
    TelaUpdate()
}
 */