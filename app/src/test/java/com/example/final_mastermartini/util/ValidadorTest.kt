package com.example.final_mastermartini.util

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Pruebas unitarias de [Validador].
 * Se ejecutan en la JVM (sin emulador): ./gradlew testDebugUnitTest
 */
class ValidadorTest {

    // ---------- RUT (módulo 11) ----------

    @Test
    fun rut_valido_con_puntos_y_guion() {
        assertTrue(Validador.validarRut("12.345.678-5"))
    }

    @Test
    fun rut_valido_sin_formato() {
        assertTrue(Validador.validarRut("123456785"))
    }

    @Test
    fun rut_valido_con_digito_verificador_K_mayuscula_y_minuscula() {
        assertTrue(Validador.validarRut("1.000.005-K"))
        assertTrue(Validador.validarRut("1.000.005-k"))
    }

    @Test
    fun rut_valido_con_digito_verificador_0() {
        assertTrue(Validador.validarRut("1.000.013-0"))
    }

    @Test
    fun rut_valido_con_espacios_alrededor() {
        assertTrue(Validador.validarRut("  12.345.678-5  "))
    }

    @Test
    fun rut_con_digito_verificador_incorrecto_es_invalido() {
        assertFalse(Validador.validarRut("12.345.678-4"))
    }

    @Test
    fun rut_muy_corto_o_vacio_es_invalido() {
        assertFalse(Validador.validarRut("123"))
        assertFalse(Validador.validarRut(""))
    }

    @Test
    fun rut_con_letras_en_el_cuerpo_es_invalido() {
        assertFalse(Validador.validarRut("12.A45.678-5"))
    }

    // ---------- Correo ----------

    @Test
    fun correos_validos() {
        assertTrue(Validador.validarCorreo("alumno@duocuc.cl"))
        assertTrue(Validador.validarCorreo("nombre.apellido+tag@gmail.com"))
        assertTrue(Validador.validarCorreo("  alumno@duocuc.cl  "))
    }

    @Test
    fun correos_invalidos() {
        assertFalse(Validador.validarCorreo(""))
        assertFalse(Validador.validarCorreo("sinarroba.cl"))
        assertFalse(Validador.validarCorreo("a@b"))
        assertFalse(Validador.validarCorreo("a@b.c"))
    }

    // ---------- Teléfono ----------

    @Test
    fun telefonos_validos() {
        assertTrue(Validador.validarTelefono("912345678"))
        assertTrue(Validador.validarTelefono("+56 9 1234 5678"))
    }

    @Test
    fun telefonos_invalidos() {
        assertFalse(Validador.validarTelefono(""))
        assertFalse(Validador.validarTelefono("1234567"))       // 7 dígitos
        assertFalse(Validador.validarTelefono("123456789012"))  // 12 dígitos
    }

    // ---------- Nombre, dirección, clave ----------

    @Test
    fun nombre_requiere_al_menos_3_caracteres() {
        assertTrue(Validador.validarNombre("Ana"))
        assertFalse(Validador.validarNombre("  Al  "))
        assertFalse(Validador.validarNombre(""))
    }

    @Test
    fun direccion_requiere_al_menos_5_caracteres() {
        assertTrue(Validador.validarDireccion("Av. Providencia 123"))
        assertFalse(Validador.validarDireccion("abc"))
    }

    @Test
    fun clave_requiere_al_menos_6_caracteres() {
        assertTrue(Validador.validarClave("123456"))
        assertFalse(Validador.validarClave("12345"))
    }
}
