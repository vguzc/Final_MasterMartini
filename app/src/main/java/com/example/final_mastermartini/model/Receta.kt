package com.example.final_mastermartini.model

import android.net.Uri
import androidx.annotation.DrawableRes
import androidx.annotation.RawRes

enum class TipoReceta {
    OFICIAL,
    COMUNIDAD,
    PROPIA
}

data class Receta(
    val id: Int,
    val titulo: String,
    val descripcion: String,
    val categoria: String,
    val tiempoMinutos: Int,
    val autor: String = "Master Martini",
    val tipo: TipoReceta = TipoReceta.OFICIAL,
    @DrawableRes val imagenRes: Int,
    val imagenUri: Uri? = null,
    @RawRes val videoRes: Int? = null,
    val videoUri: Uri? = null,
    val ingredientes: List<String> = emptyList(),
    val pasos: List<String> = emptyList(),
    val esFavorita: Boolean = false
)