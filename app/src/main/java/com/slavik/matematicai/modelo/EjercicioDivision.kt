package com.slavik.matematicai.modelo

class EjercicioDivision{

    constructor()  {
        nuevoEjercicio()
    }

    constructor(dividendo: Int, divisor: Int) {
        this.dividendo = dividendo
        this.divisor = divisor
        resolverEjercicio()
    }

    var dividendo: Int = -1
        private set

    var divisor: Int = -1
        private set

    var cociente: Int = -1
        private set

    var resto: Int = -1
        private set

    var procedimiento: MutableList<String> = mutableListOf()
        private set

    private fun generarEjercicio() {
        dividendo = (1..9999).random()
        divisor = (1..9999).random()

        // Prevenir resultados < 0
        if (divisor > dividendo) {
            val tempDivisor = dividendo
            dividendo = divisor
            divisor = tempDivisor
        }
    }

    fun nuevoEjercicio() {
        generarEjercicio()
        resolverEjercicio()
    }

    private fun resolverEjercicio() {
        // Resultado
        cociente = dividendo / divisor
        resto = dividendo % divisor

        // Procedimiento
        var tempDiv: String
        var mCociente: Int
        var mDividendo = dividendo
        var minDividendo: Int
        var dividendoLength: Int

        procedimiento.add(dividendo.toString())

        while (true) {

            // Comprobar si no se puede seguir dividiendo
            if (mDividendo < divisor) break

            // Registrar largo del dividendo de la iteración
            dividendoLength = mDividendo.toString().length

            // Elegir parte del dividendo
            tempDiv = ""

            for (n in mDividendo.toString()) {
                tempDiv += n

                if (tempDiv.toInt() > divisor) break
            }
            minDividendo = tempDiv.toInt()


            // Calcular cociente entero de la division
            mCociente = (minDividendo / divisor) * divisor

            // Agregar ceros al cociente entero
            repeat(dividendoLength - mCociente.toString().length) {
                mCociente *= 10
            }

            // Registrar cociente entero
            procedimiento.add(mCociente.toString())

            // Calcular resto / nuevo dividendo
            mDividendo -= mCociente

            // Registrar nuevo dividendo
            procedimiento.add(mDividendo.toString())
        }

        // Agregar espacios en blanco al inicio de cada paso del procedimiento
        val largoPaso = procedimiento[0].length
        var espacios: String
        var contadorCeros: Int

        for (i in procedimiento.indices) {

            espacios = ""
            repeat(largoPaso - procedimiento[i].length) {
                espacios += " "
            }
            procedimiento[i] = "${espacios}${procedimiento[i]}"
        }
    }
}