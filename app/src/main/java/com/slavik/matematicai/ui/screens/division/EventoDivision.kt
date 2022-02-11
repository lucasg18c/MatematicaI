package com.slavik.matematicai.ui.screens.division

sealed class EventoDivision{
    data class CambioCociente(val cociente: String) : EventoDivision()
    data class CambioResto(val resto: String) : EventoDivision()
    object SiguienteEjercicio : EventoDivision()
    object ComprobarResultado : EventoDivision()
}
