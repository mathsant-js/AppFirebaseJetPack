package com.example.appfirebasejetpack.ui.screens

import android.R.attr.id
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appfirebasejetpack.data.model.User
import com.example.appfirebasejetpack.data.repository.FirebaseRepository
import com.example.appfirebasejetpack.ui.navigation.Routes
import com.example.appfirebasejetpack.viewmodel.AuthViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Dashboard(
    navController: NavController,
    authViewModel: AuthViewModel
) {
    val repo = remember { FirebaseRepository() }
    var listaUsuarios by remember { mutableStateOf(listOf<User>()) }

    LaunchedEffect(Unit) {
        repo.showUsers { lista ->
            listaUsuarios = lista
        }
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "Usuários do Sistema", color = Color.Black) },
                navigationIcon = {
                    IconButton(onClick = {
                        authViewModel.signout()
                        navController.navigate(Routes.TelaLogin)
                    }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Voltar", tint = Color.Black)
                    }
                },
                actions = {
                    MenuUsuario(
                        onCriar = {
                            navController.navigate(Routes.TelaCreate)
                        },
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

           OutlinedButton(
               onClick = { navController.navigate(Routes.TelaCreate) },
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
           Spacer(modifier = Modifier.height(16.dp))

           ListaUsuarios(
               usuarios = listaUsuarios,
               onEditClick = { usuario ->
                   usuario.id.let { id ->
                       navController.navigate("telaUpdate/$id")
                   }
               },
               onDeleteClick = { usuario -> }
           )
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
    usuario: User,
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
               Row {
                   Text(text = "Nome: ${usuario.nome}", color = Color.Cyan)
               }
               Row(
                   Modifier
                       .padding(top = 5.dp)
               ) {
                   Text(text = "Email: ${usuario.email}", color = Color.Cyan)
               }
               Row(
                   Modifier
                       .padding(top = 5.dp)
               ) {
                   Text(text = "Telefone: ${usuario.telefone}", color = Color.Cyan)
               }
               Row(
                   Modifier
                       .padding(top = 5.dp)
               ) {
                   Text(text = "Mensagem: ${usuario.mensagem}", color = Color.Cyan)
               }
           }
       }
   }
}

@Composable
fun ListaUsuarios(
    usuarios: List<User>,
    onEditClick: (User) -> Unit,
    onDeleteClick: (User) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(usuarios) { usuario ->
            CardUser(
                usuario = usuario,
                onEditClick = { onEditClick(usuario) },
                onDeleteClick = { onDeleteClick(usuario) }
            )
        }
    }
}

/*
@Preview
@Composable
fun DashboardPreview() {
   Dashboard(modifier = Modifier)
}
 */