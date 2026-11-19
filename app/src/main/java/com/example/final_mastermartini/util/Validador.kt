package com.example.final_mastermartini.util

object Validador {

    fun validarRut(rut: String): Boolean {
        val rutLimpio = rut.trim().replace(".", "").replace("-", "").uppercase()

        if (rutLimpio.length < 8 || rutLimpio.length > 9) return false

        val cuerpo = rutLimpio.dropLast(1)
        val dvIngresado = rutLimpio.last()

        if (!cuerpo.all { it.isDigit() }) return false

        var suma = 0
        var multiplicador = 2

        for (digito in cuerpo.reversed()) {
            suma += digito.toString().toInt() * multiplicador
            multiplicador = if (multiplicador == 7) 2 else multiplicador + 1
        }

        val resto = suma % 11
        val dvEsperado = when (11 - resto) {
            11 -> '0'
            10 -> 'K'
            else -> (11 - resto).toString().first()
        }

        return dvIngresado == dvEsperado
    }


    fun validarCorreo(correo: String): Boolean {
        val regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\$".toRegex()
        return correo.isNotBlank() && regex.matches(correo.trim())
    }


    fun validarTelefono(telefono: String): Boolean {
        val digitos = telefono.filter { it.isDigit() }
        return digitos.length in 8..11
    }


    fun validarNombre(nombre: String): Boolean = nombre.trim().length >= 3


    fun validarDireccion(direccion: String): Boolean = direccion.trim().length >= 5


    fun validarClave(clave: String): Boolean = clave.length >= 6
}