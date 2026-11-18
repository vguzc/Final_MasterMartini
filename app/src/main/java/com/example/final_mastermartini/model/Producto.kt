package com.example.final_mastermartini.model

import androidx.annotation.DrawableRes

data class Producto(
    val id: String,
    val nombre: String,
    val marca: String = "Master Martini",
    val categoria: String,
    val subcategoria: String,
    val formato: String,
    val descripcion: String = "",
    val aplicacion: String = "Pastelería y Chocolatería",
    val esPlantBased: Boolean = false,
    @DrawableRes val imagenRes: Int = 0,
    val esDestacado: Boolean = false
)