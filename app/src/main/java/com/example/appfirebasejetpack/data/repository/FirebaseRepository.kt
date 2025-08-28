package com.example.appfirebasejetpack.data.repository

import com.example.appfirebasejetpack.data.model.User
import com.google.firebase.database.FirebaseDatabase

object FirebaseRepository {
    private val database = FirebaseDatabase.getInstance()
    private val usuariosRef = database.getReference("usuarios")

    fun addUser(nome: String, email: String, telefone: String, mensagem: String) {
        val id = usuariosRef.push().key ?: return
        val usuario = User(id, nome, email, telefone, mensagem)
        usuariosRef.child(id).setValue(usuario)
    }
}