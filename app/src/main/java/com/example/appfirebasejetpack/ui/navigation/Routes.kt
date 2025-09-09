package com.example.appfirebasejetpack.ui.navigation

object Routes {
    const val TelaLogin = "telaLogin"
    const val TelaCadastro = "telaCadastro"
    const val Dashboard = "dashboard"
    const val TelaCreate = "telaCreate"

    private const val TelaUpdateBase = "telaUpdate"
    const val TelaUpdate = "$TelaUpdateBase/{id}"

    fun telaUpdate(id: String) = "$TelaUpdateBase/$id"
}