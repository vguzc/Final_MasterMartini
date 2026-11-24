package com.example.final_mastermartini.repository

import com.example.final_mastermartini.R
import com.example.final_mastermartini.model.Curso
import com.example.final_mastermartini.model.ModalidadCurso
import com.example.final_mastermartini.model.Producto
import com.example.final_mastermartini.model.Receta
import com.example.final_mastermartini.model.TipoReceta
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

object MasterMartiniRepository {
    val productos: List<Producto> = listOf(
        Producto(
            id = "MM-CHO-01",
            nombre = "Ariba Chocolate Bitter Discos 72%",
            marca = "Ariba",
            categoria = "Chocolates",
            subcategoria = "Discos Puro",
            formato = "1 x 10 kg",
            descripcion = "Chocolate puro amargo en discos, ideal para moldear bombones finos y baños brillantes.",
            esPlantBased = true,
            imagenRes = R.drawable.ic_launcher_foreground,
            esDestacado = true
        ),
        Producto(
            id = "MM-CHO-02",
            nombre = "Caravella Crema Avellana Cacao",
            marca = "Caravella",
            categoria = "Chocolates",
            subcategoria = "Rellenos",
            formato = "1 x 5 kg",
            descripcion = "Crema untable de avellanas y cacao para rellenar medialunas, tortas y bombones.",
            imagenRes = R.drawable.ic_launcher_foreground
        ),
        Producto(
            id = "MM-CRE-01",
            nombre = "Bravo Crem Tetra Brik",
            marca = "Bravo Crem",
            categoria = "Cremas",
            subcategoria = "Cremas Reposteras",
            formato = "12 x 1 L",
            descripcion = "Crema vegetal de alto rendimiento y estabilidad para batir, decorar y rellenar.",
            esPlantBased = true,
            imagenRes = R.drawable.ic_launcher_foreground,
            esDestacado = true
        ),
        Producto(
            id = "MM-BOL-01",
            nombre = "Croissant Paris Mantequilla Congelado",
            marca = "Casa Giani",
            categoria = "Bollería Congelada",
            subcategoria = "Croissants",
            formato = "3 x 60 unid",
            descripcion = "Croissant crudo ultracongelado listo para hornear, textura hojaldrada y aroma a mantequilla.",
            imagenRes = R.drawable.ic_launcher_foreground
        )
    )

    val cursos: List<Curso> = listOf(
        Curso(
            id = 1,
            titulo = "Chocolatería Fina y Técnicas de Templado",
            chef = "Chef Maxime",
            categoria = "Chocolatería",
            modalidad = ModalidadCurso.DE_PAGO,
            precioTexto = "$25.000",
            duracion = "4 horas",
            imagenRes = R.drawable.ic_launcher_foreground,
            descripcion = "Domina el templado de chocolate bitter, con leche y blanco con la línea Ariba de Master Martini.",
            rating = 4.9f,
            incluyeCertificado = true
        ),
        Curso(
            id = 2,
            titulo = "Técnicas de Hojaldre y Masas Congeladas",
            chef = "Chef Carlos Rossi",
            categoria = "Bollería",
            modalidad = ModalidadCurso.GRATUITO,
            precioTexto = "Gratis",
            duracion = "2 horas",
            imagenRes = R.drawable.ic_launcher_foreground,
            descripcion = "Aprende el horneado perfecto de bollería y medialunas congeladas para panaderías y cafeterías.",
            rating = 4.8f,
            incluyeCertificado = false
        ),
        Curso(
            id = 3,
            titulo = "Pastelería Moderna con Cremas Vegetales",
            chef = "Chef Valentina Paz",
            categoria = "Pastelería",
            modalidad = ModalidadCurso.DE_PAGO,
            precioTexto = "$19.990",
            duracion = "3.5 horas",
            imagenRes = R.drawable.ic_launcher_foreground,
            descripcion = "Estabilidad, batido y texturas aireadas utilizando Bravo Crem en tortas de vitrina.",
            rating = 5.0f,
            incluyeCertificado = true
        )
    )

    private val recetasIniciales = listOf(
        Receta(
            id = 1,
            titulo = "Bombones de Avellana y Chocolate Bitter",
            descripcion = "Deliciosos bombones con corazón cremoso de avellanas bañados en chocolate Ariba 72%.",
            categoria = "Chocolatería",
            tiempoMinutos = 45,
            autor = "Master Martini Oficial",
            tipo = TipoReceta.OFICIAL,
            imagenRes = R.drawable.ic_launcher_foreground,
            ingredientes = listOf("300g Chocolate Ariba 72%", "150g Crema Caravella Avellana", "Molde de policarbonato"),
            pasos = listOf("1. Templar el chocolate a 31°C", "2. Encamisar el molde", "3. Rellenar y sellar"),
            esFavorita = true
        ),
        Receta(
            id = 2,
            titulo = "Torta Mousse Tres Chocolates",
            descripcion = "Torta aireada con capas de mousse elaboradas con crema vegetal Bravo Crem.",
            categoria = "Pastelería",
            tiempoMinutos = 60,
            autor = "Master Martini Oficial",
            tipo = TipoReceta.OFICIAL,
            imagenRes = R.drawable.ic_launcher_foreground,
            ingredientes = listOf("500ml Bravo Crem", "100g Chocolate Blanco", "100g Chocolate Leche", "100g Chocolate Bitter"),
            pasos = listOf("1. Batir la crema a medio punto", "2. Fundir chocolates", "3. Montar por capas y refrigerar"),
            esFavorita = false
        ),
        Receta(
            id = 3,
            titulo = "Medialunas Rellenas de Crema Pastelera",
            descripcion = "Receta compartida por un pastelero de la comunidad usando masa de hoja Master Martini.",
            categoria = "Bollería",
            tiempoMinutos = 35,
            autor = "Pastelería Don Saco Roto",
            tipo = TipoReceta.COMUNIDAD,
            imagenRes = R.drawable.ic_launcher_foreground,
            ingredientes = listOf("12 Croissants Casa Giani", "300g Crema Pastelera", "Azúcar flor para espolvorear"),
            pasos = listOf("1. Hornear los croissants a 180°C", "2. Dejar enfriar y cortar por la mitad", "3. Rellenar con manga"),
            esFavorita = false
        )
    )

    private val _recetas = MutableStateFlow(recetasIniciales)
    val recetas: StateFlow<List<Receta>> = _recetas.asStateFlow()


    fun alternarFavorito(recetaId: Int) {
        _recetas.value = _recetas.value.map { receta ->
            if (receta.id == recetaId) {
                receta.copy(esFavorita = !receta.esFavorita)
            } else {
                receta
            }
        }
    }

    fun agregarReceta(nuevaReceta: Receta) {
        _recetas.value = _recetas.value + nuevaReceta
    }
}