package com.example.appfirebasejetpack.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appfirebasejetpack.ui.navigation.Routes
import com.example.appfirebasejetpack.viewmodel.AuthState
import com.example.appfirebasejetpack.viewmodel.AuthViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Dashboard(
    modifier: Modifier,
    /*navController: NavController,
    authViewModel: AuthViewModel
     */
) {

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "Usuários do Sistema", color = Color.Black) },
                navigationIcon = {
                    IconButton(onClick = {
                        TODO()
                    }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Voltar", tint = Color.Black)
                    }
                },
                actions = {
                    MenuUsuario(
                        onCriar = {},
                        onSair = { TODO("Chamar a função de signout") }
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Cyan
                )
            )
        }
    ) {
        padding ->
        Column (
            Modifier
                .background(Color(26,26,26))
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                Icons.Filled.AccountCircle,
                contentDescription = "Usuário",
                tint = Color.Gray,
                modifier = Modifier.size(150.dp)
            )
            Text(text = "Bem-Vindo!", fontSize = 40.sp, color = Color.White)

            Spacer(modifier = Modifier.height(16.dp))

            ElevatedButton(
                onClick = {},
                colors = ButtonColors(
                    containerColor = Color.Cyan,
                    contentColor = Color.White,
                    disabledContentColor = Color.White,
                    disabledContainerColor = Color.Cyan
                )
            ) {
                Text(text = "Criar Usuário")
            }
            Spacer(modifier = Modifier.height(16.dp))

            CardUser(onEditClick = {}, onDeleteClick = {})
        }
    }

}

@Composable
fun MenuUsuario(
    onCriar: () -> Unit,
    onSair: () -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Box {
        // Botão que abre o menu
        IconButton(onClick = { expanded = true }) {
            Icon(
                imageVector = Icons.Default.MoreVert, // 3 pontinhos
                contentDescription = "Menu"
            )
        }

        // Menu suspenso
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(
                text = { Text("Criar") },
                onClick = {
                    expanded = false
                    onCriar()
                }
            )
            DropdownMenuItem(
                text = { Text("Sair da Conta") },
                onClick = {
                    expanded = false
                    onSair()
                }
            )
        }
    }
}

@Composable
fun CardUser(
    onEditClick: () -> Unit,
    onDeleteClick: () -> Unit
) {
    // Alinhar o texto com os ícones
    OutlinedCard(
        colors = CardDefaults.cardColors(
            containerColor = Color(28,28,28)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(0.5.dp, Color.Cyan),
        modifier = Modifier
            .size(width = 300.dp, height = 150.dp)
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(8.dp)
            ) {
                IconButton(onClick = onEditClick) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Editar",
                        tint = Color.Cyan
                    )
                }
                IconButton(onClick = onDeleteClick) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Excluir",
                        tint = Color.Cyan
                    )
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, top = 22.dp)
            ) {
                Text(text = "Nome:", color = Color.Cyan)
                Text(text = "Email:", color = Color.Cyan)
                Text(text = "Telefone:", color = Color.Cyan)
            }
        }
    }
}

@Preview
@Composable
fun DashboardPreview() {
    Dashboard(modifier = Modifier)
}