package com.slavik.matematicai.ui.screens.division

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.core.text.isDigitsOnly
import androidx.lifecycle.ViewModel
import com.slavik.matematicai.modelo.EjercicioDivision

class DivisionVM : ViewModel() {

    var ejercicio by mutableStateOf(EjercicioDivision())
        private set

    var mostrarResultado by mutableStateOf(false)
        private set

    var cociente by mutableStateOf("")
        private set

    var resto by mutableStateOf("")
        private set

    fun onEvento(evento: EventoDivision) {
        when (evento){
            is EventoDivision.ComprobarResultado -> {
                mostrarResultado = true
            }
            is EventoDivision.SiguienteEjercicio -> {
                mostrarResultado = false
                cociente = ""
                resto = ""
                ejercicio.nuevoEjercicio()
            }
            is EventoDivision.CambioCociente ->
                if (evento.cociente.isDigitsOnly()) cociente = evento.cociente
            is EventoDivision.CambioResto ->
                if (evento.resto.isDigitsOnly()) resto = evento.resto
        }
    }
}