package com.example.final_mastermartini.viewmodel

import androidx.lifecycle.ViewModel
import com.example.final_mastermartini.model.TipoCuenta
import com.example.final_mastermartini.model.Usuario
import com.example.final_mastermartini.model.UsuarioErrores
import com.example.final_mastermartini.model.UsuarioUiState
import com.example.final_mastermartini.util.Validador
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

/**
 * ViewModel del formulario de registro de usuario.
 *
 * - Cada cambio de campo actualiza el estado y limpia el error de ese campo.
 * - [validarFormulario] valida todos los campos con [Validador] y expone un error por campo.
 * - El estado se comparte entre el registro y la pantalla de resumen.
 */
class UsuarioViewModel : ViewModel() {

    private val _estado = MutableStateFlow(UsuarioUiState())
    val estado: StateFlow<UsuarioUiState> = _estado.asStateFlow()

    fun onNombreChange(valor: String) {
        _estado.update { it.copy(nombre = valor, errores = it.errores.copy(nombre = null)) }
    }

    fun onHandleChange(valor: String) {
        val limpio = valor.trim().removePrefix("@").replace(" ", "").lowercase()
        _estado.update { it.copy(handle = limpio, errores = it.errores.copy(handle = null)) }
    }

    fun onCorreoChange(valor: String) {
        _estado.update { it.copy(correo = valor, errores = it.errores.copy(correo = null)) }
    }

    // Solo admite dígitos, puntos, guion y K (dígito verificador)
    fun onRutChange(valor: String) {
        val limpio = valor.uppercase().filter { it.isDigit() || it == '.' || it == '-' || it == 'K' }
        _estado.update { it.copy(rut = limpio, errores = it.errores.copy(rut = null)) }
    }

    // Solo admite dígitos, espacios y el prefijo +
    fun onTelefonoChange(valor: String) {
        val limpio = valor.filter { it.isDigit() || it == '+' || it == ' ' }
        _estado.update { it.copy(telefono = limpio, errores = it.errores.copy(telefono = null)) }
    }

    fun onDireccionChange(valor: String) {
        _estado.update { it.copy(direccion = valor, errores = it.errores.copy(direccion = null)) }
    }

    fun onTipoCuentaChange(valor: TipoCuenta) {
        _estado.update { it.copy(tipoCuenta = valor, errores = it.errores.copy(empresa = null)) }
    }

    fun onEmpresaChange(valor: String) {
        _estado.update { it.copy(empresa = valor, errores = it.errores.copy(empresa = null)) }
    }

    fun onClaveChange(valor: String) {
        _estado.update { it.copy(clave = valor, errores = it.errores.copy(clave = null)) }
    }

    fun onConfirmarClaveChange(valor: String) {
        _estado.update {
            it.copy(confirmarClave = valor, errores = it.errores.copy(confirmarClave = null))
        }
    }

    fun onAceptarTerminosChange(valor: Boolean) {
        _estado.update { it.copy(aceptaTerminos = valor, errores = it.errores.copy(terminos = null)) }
    }

    /**
     * Valida todos los campos y publica los errores en el estado.
     * @return true si el formulario es válido.
     */
    fun validarFormulario(): Boolean {
        val e = _estado.value

        val errores = UsuarioErrores(
            nombre = if (!Validador.validarNombre(e.nombre)) "Ingresa al menos 3 caracteres" else null,
            handle = if (e.handle.isNotEmpty() && e.handle.length < 3) "El usuario debe tener al menos 3 caracteres" else null,
            correo = if (!Validador.validarCorreo(e.correo)) "Correo inválido" else null,
            rut = when {
                e.rut.isBlank() -> "Campo obligatorio"
                !Validador.validarRut(e.rut) -> "RUT inválido"
                else -> null
            },
            telefono = if (!Validador.validarTelefono(e.telefono)) "Teléfono inválido (8 a 11 dígitos)" else null,
            direccion = if (!Validador.validarDireccion(e.direccion)) "Ingresa una dirección válida" else null,
            empresa = if (e.tipoCuenta == TipoCuenta.EMPRESA && e.empresa.isBlank()) "Campo obligatorio para cuentas de empresa" else null,
            clave = if (!Validador.validarClave(e.clave)) "Debe tener al menos 6 caracteres" else null,
            confirmarClave = if (e.confirmarClave != e.clave) "Las contraseñas no coinciden" else null,
            terminos = if (!e.aceptaTerminos) "Debes aceptar los términos" else null
        )

        _estado.update { it.copy(errores = errores) }
        return !errores.hayErrores
    }

    /** Devuelve el [Usuario] del formulario solo si es válido. */
    fun registrarUsuario(): Usuario? =
        if (validarFormulario()) _estado.value.aUsuario() else null

    fun limpiarFormulario() {
        _estado.value = UsuarioUiState()
    }
}
