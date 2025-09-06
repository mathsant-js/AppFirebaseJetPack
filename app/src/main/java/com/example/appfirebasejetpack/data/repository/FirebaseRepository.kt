package com.example.appfirebasejetpack.data.repository

import com.example.appfirebasejetpack.data.model.User
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class FirebaseRepository {
    private val database = FirebaseDatabase.getInstance()
    private val usuariosRef = database.getReference("users")

    fun addUser(nome: String, email: String, telefone: String, mensagem: String) {
        val id = usuariosRef.push().key ?: return
        val usuario = User(id, nome, email, telefone, mensagem)
        usuariosRef.child(id).setValue(usuario)
    }

    fun showUsers(onResult: (List<User>) -> Unit) {
        usuariosRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val lista = snapshot.children.mapNotNull { it.getValue(User::class.java) }
                onResult(lista)
            }

            override fun onCancelled(error: DatabaseError) {
                println("Erro: ${error.message}")
            }
        })
    }

    fun updateUser(id: String, nome: String, email: String, telefone: String, mensagem: String) {
        val updates = mapOf(
            "nome" to nome,
            "email" to email
        )
        usuariosRef.child(id).updateChildren(updates)
    }

    fun deleteUser(id: String) {
        usuariosRef.child(id).removeValue()
    }
}