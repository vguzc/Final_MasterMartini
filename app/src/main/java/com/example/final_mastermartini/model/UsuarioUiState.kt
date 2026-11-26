package com.example.final_mastermartini.model

data class UsuarioErrores(
    val nombre: String? = null,
    val handle: String? = null,
    val correo: String? = null,
    val rut: String? = null,
    val telefono: String? = null,
    val direccion: String? = null,
    val empresa: String? = null,
    val clave: String? = null,
    val confirmarClave: String? = null,
    val terminos: String? = null
) {
    val hayErrores: Boolean
        get() = listOfNotNull(
            nombre, handle, correo, rut, telefono, direccion, empresa, clave, confirmarClave, terminos
        ).isNotEmpty()
}


data class UsuarioUiState(
    val nombre: String = "",
    val handle: String = "",
    val correo: String = "",
    val rut: String = "",
    val telefono: String = "",
    val direccion: String = "",
    val tipoCuenta: TipoCuenta = TipoCuenta.PARTICULAR,
    val empresa: String = "",
    val clave: String = "",
    val confirmarClave: String = "",
    val aceptaTerminos: Boolean = true,
    val errores: UsuarioErrores = UsuarioErrores()
) {
    fun aUsuario(): Usuario = Usuario(
        nombre = nombre.trim(),
        correo = correo.trim(),
        rut = rut.trim(),
        telefono = telefono.trim(),
        direccion = direccion.trim(),
        tipoCuenta = tipoCuenta,
        empresa = if (tipoCuenta == TipoCuenta.EMPRESA) empresa.trim() else null
    )
}
