package com.slavik.matematicai.ui.screens.division

import androidx.compose.ui.graphics.Color
import com.slavik.matematicai.modelo.EjercicioDivision
import com.slavik.matematicai.ui.theme.Violeta1

data class DivisionEstado(
    val ejercicio: EjercicioDivision = EjercicioDivision(),
    val cociente: String = "",
    val resto: String = "",
    val mostrarResultado: Boolean = false,
    val mensajeResultado: String = "",
    val mensajeProcedimiento: String = "",
    val cocienteCorrecto: Boolean = false,
    val restoCorrecto: Boolean = false,
    val colorTop: Color = Violeta1
)
