package com.example.final_mastermartini.model

import androidx.annotation.DrawableRes

enum class ModalidadCurso {
    GRATUITO,
    DE_PAGO
}

data class Curso(
    val id: Int,
    val titulo: String,
    val chef: String,
    val categoria: String,
    val modalidad: ModalidadCurso = ModalidadCurso.GRATUITO,
    val precioTexto: String = "Gratis",
    val duracion: String,
    @DrawableRes val imagenRes: Int,
    val descripcion: String,
    val rating: Float = 4.9f,
    val incluyeCertificado: Boolean = false
)