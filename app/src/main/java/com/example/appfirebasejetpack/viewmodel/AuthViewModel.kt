package com.example.appfirebasejetpack.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class AuthViewModel : ViewModel() {

    private val auth : FirebaseAuth = FirebaseAuth.getInstance()

    private val _authstate = MutableLiveData<AuthState>()
    val authstate: LiveData<AuthState> = _authstate

    init {
        checkAuthStatus()
    }

    fun checkAuthStatus() {
        if (auth.currentUser == null) {
            _authstate.value = AuthState.Unauthenticated
        } else {
            _authstate.value = AuthState.Authenticated
        }
    }

    fun login(email: String, password: String) {
        if (email.isEmpty() || password.isEmpty()) {
            _authstate.value = AuthState.Error("Email ou senha não podem ser vazios")
            return
        }
        _authstate.value = AuthState.Loading
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener{task->
                if (task.isSuccessful) {
                    _authstate.value = AuthState.Authenticated
                } else {
                    _authstate.value = AuthState.Error(task.exception?.message?:"Algo deu errado")
                }
            }
    }

    fun signup(email: String, password: String) {
        if (email.isEmpty() || password.isEmpty()) {
            _authstate.value = AuthState.Error("Email ou senha não podem ser vazios")
            return
        }
        _authstate.value = AuthState.Loading
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener{task->
                if (task.isSuccessful) {
                    _authstate.value = AuthState.Authenticated
                } else {
                    _authstate.value = AuthState.Error(task.exception?.message?:"Algo deu errado")
                }
            }
    }

    fun signout() {
        auth.signOut()
        _authstate.value = AuthState.Unauthenticated
    }
}

sealed class AuthState{
    object Authenticated : AuthState()
    object Unauthenticated : AuthState()
    object Loading : AuthState()
    data class Error(val message : String) : AuthState()
}