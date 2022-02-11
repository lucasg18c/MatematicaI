package com.slavik.matematicai.ui.screens.division

object Mensajes {

    object Ejercicio {

        val Correcto = listOf(
            "Muy bien!",
            "Excelente!",
            "Impresionante!!",
        )

        val Parcial = listOf(
            "Casi...",
            "Estuvo cerca",
            "Vas bien",
        )

        val Mal = listOf(
            "Qué pasó?",
            "Ups...",
            "Falta práctica...",
        )
    }

    object Procedimiento {
        val Correcto = listOf(
            "Respondiste correctamente el cociente y resto, seguí así!",
            "Parece que no necesitás ver como resolverlo, lo hiciste bien sin ayuda.",
            "Lo hiciste a la perfección!",
        )


        fun cocienteMal(cociente: Int) : String {
            return listOf(
                "Calculaste bien el resto, pero el cociente daba $cociente.",
                "Casi, el cociente era $cociente, seguí practicando.",
                "La práctica hace la perfección, tené cuidado al calcular cocientes.",
                "Estuviste bien, pero el cociente era $cociente.",
            ).random()
        }

        fun restoMal(resto: Int) : String {
            return listOf(
                "Calculaste bien el cociente, pero el resto daba $resto.",
                "Casi, el resto era $resto, seguí practicando.",
                "La práctica hace la perfección, tené cuidado al calcular el resto.",
                "Estuviste bien, pero el resto era $resto.",
            ).random()
        }

        val Mal = listOf(
            "Concentrate, te va a salir.",
            "No te rindas.",
            "Un poco más de práctica y lo vas a tener.",
        )
    }
}