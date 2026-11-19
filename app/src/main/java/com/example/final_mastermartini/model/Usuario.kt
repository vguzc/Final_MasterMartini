package com.example.final_mastermartini.model

enum class TipoCuenta {
    PARTICULAR,
    EMPRESA
}

data class Usuario(
    val nombre: String,
    val correo: String,
    val rut: String,
    val telefono: String,
    val direccion: String,
    val tipoCuenta: TipoCuenta = TipoCuenta.PARTICULAR,
    val empresa: String? = null
)