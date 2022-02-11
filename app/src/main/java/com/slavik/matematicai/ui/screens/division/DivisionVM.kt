package com.slavik.matematicai.ui.screens.division

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.core.text.isDigitsOnly
import androidx.lifecycle.ViewModel
import com.slavik.matematicai.modelo.EjercicioDivision
import com.slavik.matematicai.ui.theme.Naranja1
import com.slavik.matematicai.ui.theme.Rojo1
import com.slavik.matematicai.ui.theme.Verde1

class DivisionVM : ViewModel() {

    var estado by mutableStateOf(DivisionEstado())
        private set

    fun onEvento(evento: EventoDivision) {
        when (evento) {
            is EventoDivision.ComprobarResultado -> {
                val restoCorrecto = estado.resto == estado.ejercicio.resto.toString()
                val cocienteCorrecto = estado.cociente == estado.ejercicio.cociente.toString()

                estado = estado.copy(
                    mostrarResultado = true,
                    restoCorrecto = restoCorrecto,
                    cocienteCorrecto = cocienteCorrecto,
                    mensajeResultado = when{
                        cocienteCorrecto && restoCorrecto -> Mensajes.Ejercicio.Correcto.random()
                        cocienteCorrecto || restoCorrecto -> Mensajes.Ejercicio.Parcial.random()
                        else -> Mensajes.Ejercicio.Mal.random()
                    },
                    mensajeProcedimiento = when{
                        cocienteCorrecto && restoCorrecto -> Mensajes.Procedimiento.Correcto.random()
                        cocienteCorrecto -> Mensajes.Procedimiento.restoMal(estado.ejercicio.resto)
                        restoCorrecto -> Mensajes.Procedimiento.cocienteMal(estado.ejercicio.cociente)
                        else -> Mensajes.Procedimiento.Mal.random()
                    },
                    colorTop = when {
                        cocienteCorrecto && restoCorrecto -> Verde1
                        cocienteCorrecto || restoCorrecto -> Naranja1
                        else -> Rojo1
                    }
                )
            }
            is EventoDivision.SiguienteEjercicio -> {
                estado = DivisionEstado()
            }
            is EventoDivision.CambioCociente ->
                if (evento.cociente.isDigitsOnly())
                    estado = estado.copy(cociente = evento.cociente)
            is EventoDivision.CambioResto ->
                if (evento.resto.isDigitsOnly())
                    estado = estado.copy(resto = evento.resto)
        }
    }
}