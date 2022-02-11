package com.slavik.matematicai.ui.screens.restas

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.core.text.isDigitsOnly
import androidx.lifecycle.ViewModel

class RestaVM : ViewModel() {


    var numero1 by mutableStateOf("")
        private set

    var numero2 by mutableStateOf("")
        private set

    var mostrarResultado by mutableStateOf(false)
        private set

    var resultadoCorrecto by mutableStateOf(false)
        private set

    var resultadoUsuario by mutableStateOf("")
        private set

    var resultado by mutableStateOf("")
        private set

    fun cambioResultadoUsuario(resultado: String) {
        if (resultado.isDigitsOnly()) {
            resultadoUsuario = resultado
        }
    }

    fun siguienteEjercicio() {
        mostrarResultado = false
        resultadoUsuario = ""
        resultadoCorrecto = false
        numero1 = (1..9999).random().toString()
        numero2 = (1..9999).random().toString()

        if (numero1.toInt() < numero2.toInt()){
            val temp = numero1
            numero1 = numero2
            numero2 = temp
        }
        resultado = (numero1.toInt() - numero2.toInt()).toString()
    }

    fun comprobar() {
        if (resultadoUsuario.isEmpty()) return

        resultadoCorrecto = resultadoUsuario == resultado
        mostrarResultado = true
    }

    init {
        siguienteEjercicio()
    }
}